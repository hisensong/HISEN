package com.dmall.hisen.failtelorance;

/**
 * Description:失效策略枚举类
 * Author:HisenSong
 * DateTime: 2016/9/8 20:46
 */

public enum FailureToleranceStrategyEnum {
    FAIL_OVER(2, "失败重试"), FAIL_FAST(4, "失败退出"), FAIL_SAFE(8, "失败忽略"), FAIL_BACK(16, "失败后处理");

    private int code;
    private String name;

    private FailureToleranceStrategyEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static FailureToleranceStrategyEnum getByCode(int code) {
        for (FailureToleranceStrategyEnum e : FailureToleranceStrategyEnum.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }

        return null;
    }

}

