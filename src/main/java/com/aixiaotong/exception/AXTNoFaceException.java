package com.aixiaotong.exception;

public class AXTNoFaceException extends AXTBaseException {
    public AXTNoFaceException() {
        super(AXTExceptionCode.NO_FACE.getCode(), AXTExceptionCode.NO_FACE.getMessage());
    }
}
