package com.yd.yx.common.utils;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @ClassName
 * @Description:
 * @Author:
 * @Date:
 **/
public class CommonStringUtils {
    private final static Pattern CHINESE_CHARACTER_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5]");

    public static String concatMessageWithSep(String seperator, String... args) {
        return Arrays.stream(args).collect(Collectors.joining(seperator));
    }

    public static Boolean isNumber(String number) {
        if (number == null) {
            return false;
        }

        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public static int countChinese(String str) {
        int count = 0;
        Matcher m = CHINESE_CHARACTER_PATTERN.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }

    /**
     * 替换掉HTML标签方法
     */
    public static String stripHtml(String html) {
        if (isBlank(html)){
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }

    /**
     * 缩略字符串（不区分中英文字符）
     * @param str 目标字符串
     * @param length 截取长度
     * @return
     */
    public static String abbr(String str, int length) {
        if (str == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int currentLength = 0;
            for (char c : stripHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
                currentLength += String.valueOf(c).getBytes("GBK").length;
                if (currentLength <= length - 3) {
                    sb.append(c);
                } else {
                    sb.append("...");
                    break;
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
