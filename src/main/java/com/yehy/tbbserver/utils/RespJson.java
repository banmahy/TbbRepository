package com.yehy.tbbserver.utils;

/**
 * API接口基础返回类
 * @ClassName RespJSON
 * @Author yehy
 * @Date 2022/5/16 21:25
 **/
public class RespJson<T> {

        private static final int SUCCESS = 200;

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
         * 错误类型
         */
        private String errorType;

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
            respJson.setCode(SUCCESS);
            respJson.setSuccess(true);
            respJson.setMsg(msg);
            respJson.setData(data);

            return respJson;
        }

        public static RespJson newFail(String msg) {
            RespJson respJson = new RespJson();

            respJson.setSuccess(false);
            respJson.setMsg(msg);
            respJson.setErrorType("");

            return respJson;
        }

        public static RespJson newFail(String msg, Object data) {
            RespJson respJson = new RespJson();

            respJson.setSuccess(false);
            respJson.setMsg(msg);
            respJson.setData(data);
            respJson.setErrorType("");

            return respJson;
        }

        public static RespJson newError(String errorTypeEnum, String msg, Object data) {
            RespJson respJson = new RespJson();

            respJson.setSuccess(false);
            respJson.setMsg(msg);
            respJson.setData(data);
            respJson.setErrorType(errorTypeEnum);

            return respJson;
        }

        public static RespJson newError(String errorType, int code, String msg, Object data) {
            RespJson respJson = new RespJson();

            respJson.setSuccess(false);
            respJson.setMsg(msg);
            respJson.setData(data);
            respJson.setErrorType(errorType);
            respJson.setCode(code);

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

        public String getErrorType() {
            return errorType;
        }

        public void setErrorType(String errorType) {
            this.errorType = errorType;
        }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
