package com.dreamsecurity.shopface.branch;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
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
    private String businessLPath;
    private String state;
    private String approvalStatus;

    @Builder
    public Branch(long no,
                  String memberId, String name, String phone,
                  LocalDateTime registerDate,
                  String address, String detailAddress, String zipCode,
                  String businessLPath,
                  String state, String approvalStatus) {
        this.no = no;
        this.memberId = memberId;
        this.name = name;
        this.phone = phone;
        this.registerDate = registerDate;
        this.address = address;
        this.detailAddress = detailAddress;
        this.zipCode = zipCode;
        this.businessLPath = businessLPath;
        this.state = state;
        this.approvalStatus = approvalStatus;
    }
}
