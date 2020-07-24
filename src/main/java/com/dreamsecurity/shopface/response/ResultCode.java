package com.dreamsecurity.shopface.response;

import lombok.Getter;

@Getter
public enum ResultCode {
    // Example
    SUCCESS("200", "Success"),
    DB_CONNECT_FAIL("500", "DB CONNECTION ERROR");

    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
