package com.dreamsecurity.shopface.response;

import lombok.Getter;

@Getter
public class ResponseData extends ResponseBase {
    private Object data = null;

    public ResponseData(Object data) {
        setResultCode(ResultCode.SUCCESS);
        this.data = data;
    }
}
