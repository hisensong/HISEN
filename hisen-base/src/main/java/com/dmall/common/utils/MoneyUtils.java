//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyUtils {
    public MoneyUtils() {
    }

    public static String fen2yuan(Long fee) {
        return (new BigDecimal(fee.longValue())).divide(new BigDecimal("100.00"), 2, RoundingMode.HALF_UP) + "";
    }

    public static BigDecimal fen2yuanBigDecimal(Long fee) {
        return (new BigDecimal(fee.longValue())).divide(new BigDecimal("100.00"), 2, RoundingMode.HALF_UP);
    }

    public static int yuan2fen(String yuan) {
        return (new BigDecimal(yuan)).setScale(2, RoundingMode.FLOOR).multiply(new BigDecimal("100")).intValue();
    }
}
