//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.utils;

import com.dmall.common.utils.SpringUtils;
import java.util.Locale;
import org.springframework.context.MessageSource;

public class MessageUtils {
    private static MessageSource messageSource;

    public MessageUtils() {
    }

    public static String message(String code, Object... args) {
        if(messageSource == null) {
            messageSource = (MessageSource)SpringUtils.getBean(MessageSource.class);
        }

        return messageSource.getMessage(code, args, (Locale)null);
    }
}
