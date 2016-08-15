//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dmall.common.domain;

import com.dmall.common.domain.AppContext;
import com.dmall.common.domain.BaseResponseCode;
import com.dmall.common.utils.JsonUtils;
import java.io.Serializable;

public class ServiceResponse<T> implements Serializable {
    private static final long serialVersionUID = 2488663702267110932L;
    private String code;
    private String msg;
    private T result;

    public ServiceResponse<T> success() {
        return new ServiceResponse(BaseResponseCode.SUCCESS);
    }

    public ServiceResponse<T> failure(String msg) {
        return new ServiceResponse(BaseResponseCode.FAILURE.getCode(), msg);
    }

    public static ServiceResponse successResponse() {
        return new ServiceResponse(BaseResponseCode.SUCCESS);
    }

    public static ServiceResponse failureResponse() {
        return new ServiceResponse(BaseResponseCode.FAILURE);
    }

    public static ServiceResponse failureResponse(String msg) {
        return new ServiceResponse(BaseResponseCode.FAILURE.getCode(), msg);
    }

    public static ServiceResponse businessResponse(String msg) {
        return new ServiceResponse(BaseResponseCode.BUSINESS_ERROR.getCode(), msg);
    }

    public ServiceResponse() {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
    }

    public ServiceResponse(BaseResponseCode ResponseCode) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = ResponseCode.getCode();
        this.msg = ResponseCode.getMsg();
    }

    public ServiceResponse(T result) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.result = result;
    }

    public ServiceResponse(String code, String msg) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = code;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return BaseResponseCode.SUCCESS.getCode().equals(this.code);
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

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static void main(String[] args) {
        ServiceResponse response = new ServiceResponse();
        AppContext context = new AppContext();
        context.setSysSource("111");
        context.setVersion("aaa");
        response.setResult(context);
        String str = JsonUtils.toString(response);
        System.out.println(str);
    }
}
