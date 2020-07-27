package com.dreamsecurity.shopface.common.exception;

public class InvalidValueException extends CommonException {
    public InvalidValueException(String message) {
        super(message, ErrorCode.INVALID_INPUT_VALUE);
    }

    public InvalidValueException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
