package com.phoenix.littlelife.utils;

import java.security.MessageDigest;

/**
 * @author liyangyang
 * @date 2023/1/4 16:18
 */
public class Sha1Util {

    private static final char[] CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int len = digest.length;
            for (byte b : digest) {
                sb.append(CHARS[(b >> 4) & 15]);
                sb.append(CHARS[b & 15]);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

