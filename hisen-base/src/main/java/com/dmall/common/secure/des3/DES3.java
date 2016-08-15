//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.secure.des3;

import java.util.Arrays;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.util.StringUtils;

public class DES3 {
    private static final String Algorithm = "DESede";
    private static final char[] base = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public DES3() {
    }

    public static String encrypt(String message, String strKey, String encoding) throws Exception {
        String charset = StringUtils.isEmpty(encoding)?"UTF-8":encoding;
        message = message + "        ";
        byte[] bMsg = message.getBytes(charset);
        int l = (bMsg.length / 16 + 1) * 16;
        byte[] btMsg = Arrays.copyOf(bMsg, l);
        byte[] digestOfPassword = strKey.getBytes();
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        int key = 0;

        for(int c1 = 16; key < 8; keyBytes[c1++] = keyBytes[key++]) {
            ;
        }

        SecretKeySpec var12 = new SecretKeySpec(keyBytes, "DESede");
        Cipher var13 = Cipher.getInstance("DESede");
        var13.init(1, var12);
        String rtn = byte2hex(var13.doFinal(btMsg));
        return rtn.substring(0, (bMsg.length / 8 + 1) * 16);
    }

    public static String decrypt(String message, String strKey, String encoding) throws Exception {
        String charset = StringUtils.isEmpty(encoding)?"UTF-8":encoding;
        message = message + getAdd(message.length(), strKey, charset);
        byte[] digestOfPassword = strKey.getBytes();
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        int key = 0;

        for(int decipher = 16; key < 8; keyBytes[decipher++] = keyBytes[key++]) {
            ;
        }

        SecretKeySpec var9 = new SecretKeySpec(keyBytes, "DESede");
        Cipher var10 = Cipher.getInstance("DESede");
        var10.init(2, var9);
        byte[] plainText = var10.doFinal(hex2byte(message));
        return new String(plainText, charset);
    }

    public static String newKey(int len) {
        Random rd = new Random();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < len; ++i) {
            sb.append(base[Math.abs(rd.nextInt()) % 62]);
        }

        return sb.toString();
    }

    private static String getAdd(int length, String strKey, String encoding) throws Exception {
        byte[] btMsg = new byte[length / 2];
        byte[] digestOfPassword = strKey.getBytes(encoding);
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        int key = 0;

        for(int c1 = 16; key < 8; keyBytes[c1++] = keyBytes[key++]) {
            ;
        }

        SecretKeySpec var9 = new SecretKeySpec(keyBytes, "DESede");
        Cipher var10 = Cipher.getInstance("DESede");
        var10.init(1, var9);
        String rtn = byte2hex(var10.doFinal(btMsg));
        return rtn.substring(length);
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";

        for(int n = 0; n < b.length; ++n) {
            stmp = Integer.toHexString(b[n] & 255);
            if(stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }

        return hs.toUpperCase();
    }

    private static byte[] hex2byte(String s) {
        boolean m = false;
        boolean n = false;
        int l = s.length() / 2;
        byte[] b = new byte[l];

        for(int i = 0; i < l; ++i) {
            int var6 = i * 2 + 1;
            int var7 = var6 + 1;
            b[i] = uniteBytes(s.substring(i * 2, var6), s.substring(var6, var7));
        }

        return b;
    }

    private static byte uniteBytes(String src0, String src1) {
        byte b0 = Byte.decode("0x" + src0).byteValue();
        b0 = (byte)(b0 << 4);
        byte b1 = Byte.decode("0x" + src1).byteValue();
        byte ret = (byte)(b0 | b1);
        return ret;
    }
}
