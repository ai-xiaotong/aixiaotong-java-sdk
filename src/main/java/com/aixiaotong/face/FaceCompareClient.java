package com.aixiaotong.face;

import com.aixiaotong.common.AXTCommonClient;
import com.aixiaotong.common.AXTCommonRequest;
import com.aixiaotong.common.AXTCommonResponse;
import com.aixiaotong.exception.AXTBaseException;
import com.aixiaotong.exception.AXTEntityTooLargeException;
import com.aixiaotong.exception.AXTExceptionCode;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class FaceCompareClient extends AXTCommonClient {

    private static String faceCompareUrl = "http://api.ai-xiaotong.com/face/compare";
    private static final long IMAGE_MAX_BYTES = 5*1024*1024L;

    public FaceCompareClient(String akId, String akSecret) {
        super(akId, akSecret, faceCompareUrl);
    }

    public FaceCompareResponse compare(FaceCompareRequest param) throws IOException, AXTBaseException {
        String paramStr = JSONObject.toJSONString(param);
        FaceCompareResponse response = JSONObject.parseObject(post(paramStr), FaceCompareResponse.class);
        if (!response.getCode().equals(AXTExceptionCode.SUCCESS.getCode())) {
            throw new AXTBaseException(response.getCode(), response.getMessage());
        }
        return response;
    }

    public FaceCompareResponse compare(FileInputStream imageAStream, FileInputStream imageBStream) throws IOException, AXTBaseException {
        if (imageAStream.getChannel().size() > IMAGE_MAX_BYTES || imageBStream.getChannel().size() > IMAGE_MAX_BYTES) {
            throw new AXTEntityTooLargeException();
        }
        String imageA = Base64.getEncoder().encodeToString(IOUtils.toByteArray(imageAStream));
        String imageB = Base64.getEncoder().encodeToString(IOUtils.toByteArray(imageBStream));
        return compare(new FaceCompareRequest(imageA, imageB));
    }

    public FaceCompareResponse compare(InputStream imageAStream, InputStream imageBStream) throws IOException, AXTBaseException {
        byte[] imageABytes = IOUtils.toByteArray(imageAStream);
        byte[] imageBBytes = IOUtils.toByteArray(imageBStream);
        if (imageABytes.length > IMAGE_MAX_BYTES || imageBBytes.length > IMAGE_MAX_BYTES) {
            throw new AXTEntityTooLargeException();
        }
        String imageA = Base64.getEncoder().encodeToString(imageABytes);
        String imageB = Base64.getEncoder().encodeToString(imageBBytes);
        return compare(new FaceCompareRequest(imageA, imageB));
    }

    static public class FaceCompareRequest extends AXTCommonRequest {
        String imageA;
        String imageB;

        public FaceCompareRequest(String imageA, String imageB) {
            super();
            this.imageA = imageA;
            this.imageB = imageB;
        }


        public String getImageA() {
            return imageA;
        }

        public void setImageA(String imageA) {
            this.imageA = imageA;
        }

        public String getImageB() {
            return imageB;
        }

        public void setImageB(String imageB) {
            this.imageB = imageB;
        }
    }

    static public class FaceCompareResponse extends AXTCommonResponse {

        private Double score;

        public FaceCompareResponse() {
        }

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }
    }
}
