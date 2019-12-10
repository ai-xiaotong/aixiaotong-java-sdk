package com.aixiaotong.exception;

public class AXTFreqLimitException extends AXTBaseException {
    public AXTFreqLimitException() {
        super(AXTExceptionCode.FREQ_LIMIT.getCode(), AXTExceptionCode.FREQ_LIMIT.getMessage());
    }
}
