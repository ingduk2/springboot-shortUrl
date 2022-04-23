package com.example.shorturl.common.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Base62Util {
    private static final char[] BASE62 = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String encode(long value) {
        final StringBuilder sb = new StringBuilder();
        do {
            int i = (int) (value % 62);
            sb.append(BASE62[i]);
            value /= 62;
        } while (value > 0);
        return sb.toString();
    }

    public static long decode(String value) {
        long result=0;
        long power=1;
        for (int i = 0; i < value.length(); i++) {
            long digit = new String(BASE62).indexOf(value.charAt(i));
            result += digit * power;
            power *= 62;
        }
        return result;
    }
}
