package com.caiyf.appliance.repair.bs.model.result;

import lombok.Getter;

/**
 * @desc 状态码
 * @date 2019/04/10
 * @author caiyf
 */
@Getter
public enum CodeEnum {

    /** 通用状态码 */
    SUCCESS(1000, "请求成功"),
    PARAMETER_VALID_ERROR(1001, "参数异常"),
    UNKNOWN_ERROR(1002, "未知错误"),

    /** 工具错误码 */
    ENCRYPT_ERROR(1100, "加密错误"),
    DECRYPT_ERROR(1101, "解密错误"),

    /** 信息错误 */
    NULL_REGION_ERROR(1200, "地区为空");

    private Integer code;
    private String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
