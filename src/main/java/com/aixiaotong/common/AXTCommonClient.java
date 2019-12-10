package com.aixiaotong.common;

import okhttp3.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SignatureException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class AXTCommonClient {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private static final String AXT_SIGNATURE_FORMAT = "%s\n%s\n%s\n%s";
    private static final String HTTP_POST_METHOD = "POST";

    private OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build();

    private String akId;
    private String akSecret;
    private String url;

    public AXTCommonClient(String akId, String akSecret, String url) {
        this.akId = akId;
        this.akSecret = akSecret;
        this.url = url;
    }

    public String post(String bodyStr) throws IOException {
        return post(bodyStr, "application/json; charset=utf-8");
    }

    public String post(String bodyStr, String contentType) throws IOException {
        // Signature
        String signature = "";
        String contentMd5 = "";
        String date = "";
        try {
            contentMd5 =  Base64.getEncoder().encodeToString(md5(bodyStr.getBytes("UTF-8")));
            date = XDateUtils.getGMT(System.currentTimeMillis()/1000);
            signature = generateAXTSignature(akSecret, HTTP_POST_METHOD, contentMd5, contentType, date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String authorization = String.format("AXT-HMAC-SHA1 %s:%s", akId, signature);
        RequestBody body = RequestBody.create(MediaType.parse(contentType), bodyStr);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("content-type", contentType)
                .addHeader("content-md5", contentMd5)
                .addHeader("date", date)
                .addHeader("content-length", String.valueOf(bodyStr.getBytes("UTF-8").length))
                .addHeader("authorization", authorization)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static byte[] hmacSHA1(byte[] key, byte[] data) throws java.security.SignatureException {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1_ALGORITHM);
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);
            return mac.doFinal(data);
        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : "
                    + e.getMessage());
        }
    }

    public static byte[] md5(byte[] data) throws SignatureException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data);
            return md.digest();
        } catch (Exception e) {
            throw new SignatureException("Failed to generate MD5 : "
                    + e.getMessage());
        }
    }

    public static String generateAXTSignature(String akSecret, String method, String contentMd5, String contentType, String date) throws UnsupportedEncodingException, SignatureException {
        return Base64.getEncoder().encodeToString(
                hmacSHA1(akSecret.getBytes("UTF-8"),
                        String.format(AXT_SIGNATURE_FORMAT, method, contentMd5, contentType, date).getBytes("UTF-8")
                )
        );
    }
}
