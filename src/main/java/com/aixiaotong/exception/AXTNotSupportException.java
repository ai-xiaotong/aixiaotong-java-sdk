package com.aixiaotong.exception;

public class AXTNotSupportException extends AXTBaseException {
    public AXTNotSupportException() {
        super(AXTExceptionCode.NOT_SUPPORT.getCode(), AXTExceptionCode.NOT_SUPPORT.getMessage());
    }
}
