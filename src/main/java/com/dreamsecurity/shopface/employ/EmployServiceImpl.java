package com.dreamsecurity.shopface.employ;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployServiceImpl implements EmployService {
    private final EmployMapper employMapper;

    @Override
    public boolean addEmploy(Employ employ) {
        return false;
    }

    @Override
    public List<Employ> getEmployList(Employ employ) {
        return null;
    }

    @Override
    public Employ getEmploy(Employ employ) {
        return null;
    }

    @Override
    public boolean editEmploy(Employ employ) {
        return false;
    }

    @Override
    public boolean removeEmploy(Employ employ) {
        return false;
    }

    @Override
    public String createAuthCode() {
        return null;
    }

    @Override
    public String verificationAuthCode(Employ employ) {
        return null;
    }

    @Override
    public String checkCertiCode(Employ employ, String expiredDate) {
        return null;
    }

    @Override
    public boolean sendInviteMessage(Employ employ) {
        return false;
    }

    @Override
    public boolean resendInviteMessage(Employ employ) {
        return false;
    }
}
