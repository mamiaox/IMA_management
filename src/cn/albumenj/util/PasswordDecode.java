package cn.albumenj.util;

import java.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordDecode {
    public static String EncoderByMd5(String str){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] strb = md5.digest(str.getBytes("utf-8"));
            String newstr = new String(Base64.getEncoder().encode(strb));
            return newstr;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
