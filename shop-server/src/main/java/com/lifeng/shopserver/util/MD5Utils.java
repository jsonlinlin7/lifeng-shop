package com.lifeng.shopserver.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @purpose: MD5加密工具类，避免密码文本模式在网络上传输
 */
public class MD5Utils {
    
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str. getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest [offset];
                if(i<0)
                    i += 256;
                if(i<16)
                    buf.append("'");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf. toString();
            //16位的加密
            //return buf. toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

