package com.dreamsecurity.shopface.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TestErrorCode {
    // common
    INVALID_INPUT_VALUE(400, "M001", "Invalid Input Value"),

    // Member,
    NOT_EXIST_MEMBER(400, "M002", "Does Not Exist Member");

    // Branch

    // Employ

    // Occupation

    // Timetable

    // Schedule

    // Record

    // Alarm

    private final String code;
    private final String message;
    private int status;

    TestErrorCode(final int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
