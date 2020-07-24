package com.dreamsecurity.shopface.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBase {
    private String code;
    private String message;

    public ResponseBase() {
       setResultCode(ResultCode.SUCCESS);
    }

    public ResponseBase(Exception exception) {
        this.code = "500";
        this.message = exception.getClass().getCanonicalName() + " / " + exception.getMessage();
    }

    protected void setResultCode(final ResultCode resultCode) {
        code = resultCode.getCode();
        message = resultCode.getMessage();
    }
}
