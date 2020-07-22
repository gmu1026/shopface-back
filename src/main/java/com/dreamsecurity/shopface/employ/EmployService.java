package com.dreamsecurity.shopface.employ;

import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;

import java.util.List;

public interface EmployService {
    public HttpStatus addEmploy(Employ employ);
    public List<Employ> getEmployList(Employ employ);
    public Employ getEmploy(Employ employ);
    public HttpStatus editEmploy(Employ employ);
    public HttpStatus removeEmploy(Employ employ);
    public String createAuthCode();
    public String verificationAuthCode(Employ employ);
    public String checkCertiCode(Employ employ, String expiredDate);
    public SimpleMailMessage createInviteMessage(Employ employ);
    public boolean sendInviteMessage(Employ employ);
    public boolean resendInviteMessage(Employ employ);
}
