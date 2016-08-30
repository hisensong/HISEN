package com.dmall.hisen.utils;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2015/9/12 17:52
 */
public class DES3Utils {

    //定义加密算法，DESede
    private static final String Algorithm = "DESede";

    private static final String Cipher_Algorithm = "DESede/ECB/PKCS5Padding";

    public static final String AES_KEY = "balabalabalabala";

    public static String encrypt(String text) throws Exception {
        String key = AES_KEY;
        return DES3Utils.encrypt(text, key, "UTF-8");
    }

    public static String decrypt(String text) throws Exception {
        String key = AES_KEY;
        return DES3Utils.decrypt(text, key, "UTF-8");
    }

    /**
     * 加密方法
     */
    public static String encrypt(String text, String key, String charset) throws Exception {
        byte[] keybyte = hex(key);

        DESedeKeySpec desKeySpec = new DESedeKeySpec(keybyte);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(Algorithm);
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        Cipher cipher = Cipher.getInstance(Cipher_Algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] textBytes = text.getBytes(charset);//明文UTF-8格式
        byte[] bytes = cipher.doFinal(textBytes);//DESede加密

        return Base64.encode(bytes);//BASE64.encode(bytes);//base64编码
    }

    /**
     * 解密方法
     */
    public static String decrypt(String text, String key, String charset) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IOException, BadPaddingException, IllegalBlockSizeException {
        byte[] keybyte = hex(key);

        DESedeKeySpec desKeySpec = new DESedeKeySpec(keybyte);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(Algorithm);
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        Cipher cipher = Cipher.getInstance(Cipher_Algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        //base64解密
        byte[] textBytes = Base64.decode(text);
        byte[] bytes = cipher.doFinal(textBytes);

        return new String(bytes, charset);
    }

    /**
     * 组装key
     */
    public static byte[] hex(String key) {
        byte[] bkeys = MD5.MD5Encode(key).getBytes();
        byte[] enk = new byte[24];
        System.arraycopy(bkeys, 0, enk, 0, 24);
        return enk;
    }
}
