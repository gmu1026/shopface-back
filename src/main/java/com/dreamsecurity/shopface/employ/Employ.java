package com.dreamsecurity.shopface.employ;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Alias("employ")
public class Employ {
    private int no;
    private String memberId;
    private String name;
    private int branchNo;
    private int salary;
    private String certiCode;
    private Date employDate;
    private Date closeDate;
    private char state;
    private String email;
    private String phone;
    private String bankName;
    private long accountNum;


    @Builder
    public Employ(int no, String memberId, String name,
                  int branchNo, int salary,
                  String certiCode,
                  Date employDate, Date closeDate,
                  char state,
                  String email, String phone, String bankName, long accountNum) {
        this.no = no;
        this.memberId = memberId;
        this.name = name;
        this.branchNo = branchNo;
        this.salary = salary;
        this.certiCode = certiCode;
        this.employDate = employDate;
        this.closeDate = closeDate;
        this.state = state;
        this.email = email;
        this.phone = phone;
        this.bankName = bankName;
        this.accountNum = accountNum;
    }
}
