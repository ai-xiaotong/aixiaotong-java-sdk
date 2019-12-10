package com.aixiaotong.common;

import java.util.UUID;

public class AXTCommonRequest {

    protected String requestId;

    public AXTCommonRequest() {
        this.requestId = UUID.randomUUID().toString();
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
