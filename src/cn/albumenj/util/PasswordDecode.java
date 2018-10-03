package cn.albumenj.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import java.security.MessageDigest;

/**
 * @author Albumen
 */
public class PasswordDecode {
    public static String EncoderByMd5(String str){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] strb = md5.digest(str.getBytes(StandardCharsets.UTF_8));
            return new String(Base64.getEncoder().encode(strb));
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
