package com.dreamsecurity.shopface.branch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Alias("Branch")
public class Branch {
    private long no;
    private String memberId;
    private String name;
    private String phone;
    private LocalDateTime registerDate;
    private String address;
    private String detailAddress;
    private String zipCode;
    private String businessLicensePath;
    private String state;
    private String approvalStatus;
}
