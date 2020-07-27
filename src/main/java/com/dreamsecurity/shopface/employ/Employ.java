package com.dreamsecurity.shopface.employ;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Alias("Employ")
public class Employ {
    private long no;
    private long branchNo;
    private String memberId;
    private String name;
    private long salary;
    private String certiCode;
    private LocalDateTime employDate;
    private LocalDateTime closeDate;
    private String state;
    private String email;
    private String phone;
    private String bankName;
    private long accountNum;
}
