package com.dmall.hisen.stragy;

/**
 * Description:策略枚举类
 * Author:HisenSong
 * DateTime: 2017/5/17 11:01
 */

public enum StrateEnum {
    STRATEGE_A("0","stratege_a"),
    STRATEGE_B("1","stratege_b");

    private String code;
    private String name;

    private StrateEnum(String code,String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static StrateEnum getByCode(String code){
        for (StrateEnum e : StrateEnum.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }
}
