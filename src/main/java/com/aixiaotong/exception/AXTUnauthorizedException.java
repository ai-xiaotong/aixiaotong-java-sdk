package com.aixiaotong.exception;

public class AXTUnauthorizedException extends AXTBaseException {
    public AXTUnauthorizedException() {
        super(AXTExceptionCode.UNAUTHORIZED.getCode(), AXTExceptionCode.UNAUTHORIZED.getMessage());
    }
}
