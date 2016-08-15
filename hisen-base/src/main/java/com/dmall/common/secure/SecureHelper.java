//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.secure;

import com.dmall.common.secure.des3.DES3;

public class SecureHelper {
    public SecureHelper() {
    }

    public static String des3Encrypt(String text, String key, String encoding) throws Exception {
        return DES3.encrypt(text, key, encoding);
    }

    public static String des3Decrypt(String text, String key, String encoding) throws Exception {
        return DES3.decrypt(text, key, encoding);
    }
}
