package com.zfcgdbinterface.response;

import lombok.Getter;

/**
 * @author zht
 * API格式封装
 */
@Getter
public class ApiResponse {

    //编码
    private int code;

    //消息
    private String message;

    //数据
    private Object data;

    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    /**
      * 成功后返回的api类型
      * @author zht
      */
    public static ApiResponse ofSuccess(Object data) {
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getStandardMessage(), data);
    }

    /**
      * 错误后返回的api类型
      * @author zht
      * @param status:传入枚举
      * @return com.cook.response.ApiResponse
      */
    public static ApiResponse ofError(Status status) {
        return new ApiResponse(status.getCode(), status.getStandardMessage(),null);
    }

    public static ApiResponse ofError(String message) {
        return new ApiResponse(50001,message,null);
    }

    public static ApiResponse ofError(int code, String message) {
        return new ApiResponse(code,message,null);
    }

    /**
     * 正确后返回的api类型
     * @author zht
     * @param  status:传入枚举
     * @return com.cook.response.ApiResponse
     */
    public static ApiResponse ofData(Object data, Status status) {
        return new ApiResponse(status.getCode(), status.getStandardMessage(),data);
    }

    public enum Status {

        /**
         * 成功
         */
        SUCCESS(200, "success"),
        BAD_REQUEST(400, "Bad Request"),
        NOT_FOUND(404, "Not Found"),
        INTERNAL_SERVER_ERROR(50001, "unknownException"),
        FAILURE_JSON_FORMAT(40016,"JSON格式错误"),
        APPLY_SUBMIT_ERROR(40017,"请检查表单信息是否填写正确"),
        APPLY_IP_NOT_PASS(40018,"请勿重复提交"),
        APPLY_INSERT_ERROR(40019,"提交失败"),
        ;

        private int code;
        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }
}
