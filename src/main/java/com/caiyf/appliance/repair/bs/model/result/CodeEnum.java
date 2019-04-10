package com.caiyf.appliance.repair.bs.model.result;

/**
 * @desc 状态码
 * @date 2019/04/10
 * @author caiyf
 */
public enum CodeEnum {

    /** 通用状态码 */
    SUCCESS(1000, "请求成功"),
    PARAMETER_VALID_ERROR(1001, "参数异常"),
    UNKNOWN_ERROR(1002, "未知错误");

    private Integer code;
    private String msg;

    private CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}