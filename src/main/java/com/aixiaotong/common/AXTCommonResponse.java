package com.aixiaotong.common;

public class AXTCommonResponse {

    /**
     *
     */
    private Integer code;
    private String message;

    public AXTCommonResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("AXTCommonResponse[code=%d,message=%s]", code, message);
    }
}
