package com.dreamsecurity.shopface.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    MEMBER("ROLE_MEMBER"),
    BUSINESSMAN("ROLE_BUSINESSMAN");

    private String value;
}
