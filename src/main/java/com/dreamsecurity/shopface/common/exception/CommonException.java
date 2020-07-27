package com.dreamsecurity.shopface.common.exception;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {
    private TestErrorCode errorCode;

    public CommonException(String message, TestErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CommonException(TestErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
