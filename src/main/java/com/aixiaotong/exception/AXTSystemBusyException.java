package com.aixiaotong.exception;

public class AXTSystemBusyException extends AXTBaseException {
    public AXTSystemBusyException() {
        super(AXTExceptionCode.SYSTEM_BUSY.getCode(), AXTExceptionCode.SYSTEM_BUSY.getMessage());
    }
}
