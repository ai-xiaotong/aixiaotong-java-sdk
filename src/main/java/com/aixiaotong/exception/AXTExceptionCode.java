package com.aixiaotong.exception;

public enum AXTExceptionCode {

    SUCCESS(20000, "成功"),
    PARAM_ERROR(40000, "参数错误"),
    FREQ_LIMIT(40002, "频繁调用"),
    UNAUTHORIZED(40100, "鉴权失败"),
    INACTIVE(40301, "未开通"),
    INSUFFICIENT_BALANCE(40302, "余量不足"),
    NO_FACE(40020, "未检测到人脸"),
    ENTITY_TOO_LARGE(41300, "实体太大"),
    INTERNAL_ERROR(50000, "服务异常"),
    NOT_SUPPORT(50101, "不支持"),
    SYSTEM_BUSY(50006, "系统繁忙")
    ;

    private int code;
    private String message;

    AXTExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static String getMessage(Integer code) {
        for (AXTExceptionCode e : AXTExceptionCode.values()) {
            if (e.getCode().equals(code)) {
                return e.getMessage();
            }
        }
        return "";
    }
}
