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
    PARAMETER_VALID(1001, "参数异常"),
    UNKNOWN_ERROR(1002, "未知错误"),

    /** 工具错误码 */
    ENCRYPT_ERROR(1100, "加密错误"),
    DECRYPT_ERROR(1101, "解密错误"),
    HTTP_GET_ERROR(1102, "GET请求错误"),
    HTTP_POST_ERROR(1103, "POST请求错误"),
    GET_CODE_ERROR(1104, "GET返回码错误"),

    /** 信息错误 */
    NULL_REGION(1200, "地区为空"),

    /** 用户登录错误 */
    NULL_USER(1300, "用户为空"),
    NULL_NUM(1301, "工号为空"),
    NULL_PASSWORD(1302, "密码为空"),
    PASSWORD_ERROR(1303, "密码错误"),
    NOT_EXIST_USER(10304, "用户不存在"),

    /** 微信相关 */
    LOGIN_ERROR(1400, "登录失败"),
    DATE_FOMMATE_ERROR(1401, "日期格式错误"),

    /** 业务相关 */
    NO_SUITABLE_REPAIRER_ERROR(1500, "暂无空闲维修员，请稍后重试");

    private Integer code;
    private String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
