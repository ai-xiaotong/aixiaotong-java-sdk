package com.aixiaotong.exception;

public class AXTInactiveException extends AXTBaseException {
    public AXTInactiveException() {
        super(AXTExceptionCode.INACTIVE.getCode(), AXTExceptionCode.INACTIVE.getMessage());
    }
}
