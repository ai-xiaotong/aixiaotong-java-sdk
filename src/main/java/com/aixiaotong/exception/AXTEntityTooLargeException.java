package com.aixiaotong.exception;

public class AXTEntityTooLargeException extends AXTBaseException {
    public AXTEntityTooLargeException() {
        super(AXTExceptionCode.ENTITY_TOO_LARGE.getCode(), AXTExceptionCode.ENTITY_TOO_LARGE.getMessage());
    }
}
