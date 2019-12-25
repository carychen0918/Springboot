package com.carychen.springboot_mybatis.demo.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by chentao
 * Date by 2019-11-28
 * 无敌太寂寞
 */
public class CryptoUtil {

    private static final String UTF_8 = "UTF-8";

    /**
     * 对给定的字符串进行base64解码操作
     */
    public static String decodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.decodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }

        return null;
    }

    /**
     * 对给定的字符串进行base64加密操作
     */
    public static String encodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }

        return null;
    }

    public static void main(String[] args) {
        String jm = encodeData("LXL201314@");
        String jiemi = decodeData(jm);
        System.out.println("加密"+jm);
        System.out.println("解密"+jiemi);
    }

}