package com.aixiaotong.exception;

public class AXTParamErrorException extends AXTBaseException {
    public AXTParamErrorException() {
        super(AXTExceptionCode.PARAM_ERROR.getCode(), AXTExceptionCode.PARAM_ERROR.getMessage());
    }
}
