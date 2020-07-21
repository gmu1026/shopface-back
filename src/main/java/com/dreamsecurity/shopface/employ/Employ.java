package com.dreamsecurity.shopface.employ;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
