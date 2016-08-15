//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.domain;

public enum BaseResponseCode {
    SUCCESS("0", "SUCCESS"),
    FAILURE("-1", "FAILURE"),
    BUSINESS_ERROR("-10", "业务异常"),
    PARAMETER_VALIDATION_FAILURE("0003", "请求参数格式校验失败");

    private String code;
    private String msg;

    private BaseResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
