package com.carton.util;

import java.text.DecimalFormat;

public class StringHandlerUtil {
    public static String captureName(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    public static String generateGetMethodName(String name) {
        return "get" + captureName(name);
    }

    public static String generateSetMethodName(String name) {
        return "set" + captureName(name);
    }

    public static String numberFormat(String format, int num) {
        return new DecimalFormat(format).format(num);
    }

    public static String numberFormat(String format, double num) {
        return new DecimalFormat(format).format(num);
    }

}
