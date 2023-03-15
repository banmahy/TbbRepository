package com.yehy.tbbserver.utils;

import com.yehy.tbbserver.constants.HttpStatusConstants;

/**
 * API接口基础返回类
 *
 * @ClassName RespJSON
 * @Author yehy
 * @Date 2022/5/16 21:25
 **/
public class RespJson<T> {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 说明
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * api请求状态编号
     */
    private int code;

    public static RespJson newSuccess() {
        return newSuccess("success", null);
    }

    public static RespJson newSuccess(String msg) {
        return newSuccess(msg, null);
    }

    public static RespJson newSuccess(String msg, Object data) {
        RespJson respJson = new RespJson();
        respJson.setCode(HttpStatusConstants.SUCCESS);
        respJson.setSuccess(true);
        respJson.setMsg(msg);
        respJson.setData(data);

        return respJson;
    }

    public static RespJson newFail(int code,String msg) {
        RespJson respJson = new RespJson();
        respJson.setCode(code);
        respJson.setSuccess(false);
        respJson.setMsg(msg);

        return respJson;
    }

    public static RespJson newFail(int code,String msg, Object data) {
        RespJson respJson = new RespJson();
        respJson.setCode(code);
        respJson.setSuccess(false);
        respJson.setMsg(msg);
        respJson.setData(data);

        return respJson;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
