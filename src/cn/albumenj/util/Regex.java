package cn.albumenj.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Albumen
 */
public class Regex {
    public static boolean number(String str){

        String regEx = "^[0-9]*$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();

    }
}
