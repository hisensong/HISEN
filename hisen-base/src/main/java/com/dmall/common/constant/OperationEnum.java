//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.constant;

public enum OperationEnum {
    SAVE(1, "保存"),
    UPDATE(2, "修改"),
    DELETE(3, "删除");

    private int code;
    private String name;

    private OperationEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
