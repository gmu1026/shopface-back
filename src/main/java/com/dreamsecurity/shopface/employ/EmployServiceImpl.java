package com.dreamsecurity.shopface.employ;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_EXCLUSIONPeer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class EmployServiceImpl implements EmployService{
    private final EmployMapper employMapper;
    private final JavaMailSender mailSender;

    @Value("${secretKey}")
    private String secretKey;

    @Transactional
    @Override
    public HttpStatus addEmploy(Employ employ) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if ((employ.getEmail() != null && employ.getEmail() != "")
                &&(employ.getName() != null && employ.getName() != "")
                &&employ.getBranchNo() != 0) {
            employ.setCertiCode(verificationAuthCode(employ));

            boolean isSuccess = sendInviteMessage(employ);

            if(isSuccess == true) {
                employMapper.insert(employ);
                status = HttpStatus.OK;
            } else {
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            status = HttpStatus.BAD_REQUEST;
        }

        return status;
    }

    @Override
    public String verificationAuthCode(Employ employ) {
        String certiCode = "";
        while (true) {
            certiCode = createAuthCode();
            employ.setCertiCode(certiCode);

            if (employMapper.select(employ) == null) {
                return certiCode;
            }
        }
    }

    @Override
    public String createAuthCode() {
        Random random = new Random();

        String certiCode = "";
        for (int i = 0; i < 6; i++) {
            certiCode += String.valueOf((char) ((int) (random.nextInt(26)) + 65));
        }

        return certiCode;
    }

    @Override
    public boolean sendInviteMessage(Employ employ) {
        boolean isSuccess = false;

        SimpleMailMessage message = createInviteMessage(employ);
        try {
            mailSender.send(message);

            isSuccess = true;
        } catch (MailException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    public SimpleMailMessage createInviteMessage(Employ employ) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = simpleDateFormat.format(new Date());
        String encryptDate = null;

        try {
            CryptogramImpl cryptogramImpl = new CryptogramImpl(secretKey);
            encryptDate = cryptogramImpl.encrypt(currentDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String serverUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        String contents = "안녕하세요" + employ.getName() + "님 \r\n" + "초대경로와 인증코드 첨부드립니다. \r\n" + "초대경로 : "
                + serverUrl + "/employ/auth?date=" + encryptDate + "\r\n" + "인증 코드 : " + employ.getCertiCode();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(employ.getEmail());
        message.setSubject("페이스원 초대메시지 안내 메시지");
        message.setText(contents);

        return message;
    }

    @Override
    public List<Employ> getEmployList(Employ employ) {
        return employMapper.selectAll(employ);
    }

    @Override
    public Employ getEmploy(Employ employ) {
        return employMapper.select(employ);
    }

    @Transactional
    @Override
    public HttpStatus editEmploy(Employ employ) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (employ.getName() != null && employ.getName() != "") {
            employMapper.update(employ);

        } else if (employ.getCertiCode() != null) {
            Employ existEmploy = employMapper.select(employ);
            existEmploy.setState('C');
            existEmploy.setEmployDate(new Date(Calendar.getInstance().getTime().getTime()));

            employMapper.update(existEmploy);
            status = HttpStatus.OK;
        }

        return status;
    }

    @Transactional
    @Override
    public HttpStatus removeEmploy(Employ employ) {

        employMapper.delete(employ);

        return HttpStatus.OK;
    }

    @Transactional
    @Override
    public boolean resendInviteMessage(Employ employ) {
        boolean isSuccess = false;

        if (employ.getEmail() != null && employ.getEmail() != "") {
            Employ savedEmploy = employMapper.select(employ);
            savedEmploy.setEmail(employ.getEmail());
            savedEmploy.setCertiCode(verificationAuthCode(savedEmploy));

            isSuccess = sendInviteMessage(savedEmploy);
            if(isSuccess == true) {
                if ('D' == savedEmploy.getState()) {
                    savedEmploy.setEmployDate(null);
                    savedEmploy.setCloseDate(null);

                    employMapper.update(savedEmploy);
                    savedEmploy.setState('B');
                }

                employMapper.update(savedEmploy);
            }
        }

        return isSuccess;
    }

    @Transactional
    @Override
    public String checkCertiCode(Employ employ, String expiredDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        CryptogramImpl cryptogram = new CryptogramImpl(secretKey);
        String decryptDate = "";
        Date targetDate = null;
        Date currentDate = null;
        try {
            decryptDate = cryptogram.decrypt(expiredDate);
            targetDate = simpleDateFormat.parse(decryptDate);
            currentDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String result = "F";

        int compareResult = targetDate.compareTo(currentDate);
        if (compareResult <= 0) {
            Employ existEmploy = employMapper.select(employ);
            if (existEmploy != null
                    && existEmploy.getMemberId() != null) {
                result = "R";
            } else if (existEmploy != null) {
                result = "S";
            }
        }

        return result;
    }
}

