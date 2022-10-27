package com.phoenix.littlelife.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AesUtil {
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

    private static final String KEY = "a97f1cd37f564242";

    private static final Integer KEY_SIZE = 16;

    /**
     * AES加密
     *
     * @param content 加密内容
     * @param key     加密密码，由字母或数字组成
     *                此方法使用AES-128-ECB加密模式，key需要为16位
     *                加密解密key必须相同，如：a97f1cd37f564242
     * @return 加密密文
     */
    public static String encrypt(String content, String key) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(content) || key.length() != KEY_SIZE) {
            return null;
        }
        try {
            byte[] raw = key.getBytes();
            SecretKeySpec sKey = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            byte[] encodeContent = cipher.doFinal(byteContent);
            return Base64.encodeBase64String(encodeContent);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String content) {
        return encrypt(content, KEY);
    }


    /**
     * AES解密
     *
     * @param content 加密密文
     * @param key     加密密码,由字母或数字组成
     *                此方法使用AES-128-ECB加密模式，key需要为16位
     *                加密解密key必须相同
     * @return 解密明文
     */
    public static String decrypt(String content, String key) {
        if (key == null || "".equals(key) || key.length() != 16) {
            return null;
        }
        try {
            byte[] raw = key.getBytes();
            SecretKeySpec sKey = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, sKey);
            byte[] encodeContent = Base64.decodeBase64(content);
            byte[] byteContent = cipher.doFinal(encodeContent);
            return new String(byteContent, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String content) {
        return decrypt(content, KEY);
    }


}
