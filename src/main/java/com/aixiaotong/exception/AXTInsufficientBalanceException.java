package com.aixiaotong.exception;

public class AXTInsufficientBalanceException extends AXTBaseException {
    public AXTInsufficientBalanceException() {
        super(AXTExceptionCode.INSUFFICIENT_BALANCE.getCode(), AXTExceptionCode.INSUFFICIENT_BALANCE.getMessage());
    }
}
