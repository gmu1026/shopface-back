package com.dreamsecurity.shopface.Member;

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
}
