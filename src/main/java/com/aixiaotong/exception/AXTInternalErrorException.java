package com.aixiaotong.exception;

public class AXTInternalErrorException extends AXTBaseException {
    public AXTInternalErrorException() {
        super(AXTExceptionCode.INTERNAL_ERROR.getCode(), AXTExceptionCode.INTERNAL_ERROR.getMessage());
    }
}
