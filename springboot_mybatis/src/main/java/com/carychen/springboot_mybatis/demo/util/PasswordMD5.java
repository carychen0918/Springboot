package com.carychen.springboot_mybatis.demo.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 密码加密工具
 * Created by chentao
 * Date by 2019-11-22
 * 无敌太寂寞
 */
public class PasswordMD5 {
    private static final String UTF_8 = "UTF-8";
    /**
     * 密码加密
     * @param password
     * @return
     */
    public static String setPassword(String password){
        try {
            if (null == password) {
                return null;
            }
            return new String(Base64.encodeBase64(password.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }

        return null;
    }

    /**
     * 解密
     * @param password
     * @return
     */
    public static String convertMD5(String password){
        try {
            if (null == password) {
                return null;
            }
            return new String(Base64.decodeBase64(password.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }

        return null;

    }

    public static void main(String[] args) {
        System.out.println("setPassword"+setPassword("LXL201314ct"));
    }

    /**
     * 密码初始化
     * @return
     */
    public String setPasswordInfo(){
        Date d = new Date();
        SimpleDateFormat newdate = new SimpleDateFormat("yyyyMMdd");
        String PasswordInfo =newdate.format(d)+ "Abc123";
        return setPassword(PasswordInfo);
    }

}
