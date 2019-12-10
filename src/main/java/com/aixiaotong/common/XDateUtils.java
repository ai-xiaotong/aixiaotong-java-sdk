package com.aixiaotong.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class XDateUtils {

    /**
     * 日期格式枚举类，根据需要添加其他格式
     **/
    public enum DatePattern {
        UTC("yyyy-MM-dd'T'HH:mm:ss'Z'"),
        GMT("EEE, dd MMM yyyy HH:mm:ss 'GMT'"),
        DATE_MINUTE("yyyy-MM-dd HH:mm"),
        DATE_TIME("yyyy-MM-dd HH:mm:ss"),
        DATE_TIME_FULL("yyyy-MM-dd HH:mm:ss,SSS"),
        DAY_HALF("hh:mm a"),
        DATE_ONLY("yyyy-MM-dd"),
        DATE_INT("yyyyMMdd"),
        MONTH_INT("yyyyMM"),
        ONLY_MONTH_INT("MM"),
        ONLY_DAY_INT("dd"),
        YEAR_INT("yyyy"),
        MONTH_DAY("MM月dd日"),
        YEAR_MONTH("yyyy-MM")
        ;

        DatePattern(String pattern) {
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }

        private String pattern;

    }

    /**
     * 将long时间戳转换成GMT日期，例如Thu Oct 16 07:13:48 GMT 2015
     *
     * @param timestamp 时间戳，单位：秒
     * @return String 日期字符串
     */
    public static String getGMT(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.GMT.getPattern(), Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(new Date(timestamp * 1000));
    }
}
