package com.dreamsecurity.shopface.common.exception;

public class InvalidValueException extends CommonException {
    public InvalidValueException(String message) {
        super(message, TestErrorCode.INVALID_INPUT_VALUE);
    }

    public InvalidValueException(String message, TestErrorCode errorCode) {
        super(message, errorCode);
    }
}
