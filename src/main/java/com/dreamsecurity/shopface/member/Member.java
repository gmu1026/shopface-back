package com.dreamsecurity.shopface.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Alias(value = "member")
public class Member {
    private String id;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String bankName;
    private String accountNum;
    private LocalDateTime registerDate;
    private String state;
    private String type;
    private String address;
    private String detailAddress;
    private String zipCode;

    @Builder
    public Member(String id,
                  String name, String password,
                  String phone, String email,
                  String bankName, String accountNum,
                  LocalDateTime registerDate,
                  String state, String type,
                  String address, String detailAddress, String zipCode) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.bankName = bankName;
        this.accountNum = accountNum;
        this.registerDate = registerDate;
        this.state = state;
        this.type = type;
        this.address = address;
        this.detailAddress = detailAddress;
        this.zipCode = zipCode;
    }
}
