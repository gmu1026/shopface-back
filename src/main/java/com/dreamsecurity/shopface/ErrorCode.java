package com.dreamsecurity.shopface;

public enum ErrorCode {

    EXAMPLE("C001", " Invalid Input Value");

    private final String code;
    private final String message;

    ErrorCode(final String code, final String message) {
        this.message = message;
        this.code = code;
    }
}
