package com.caiyf.appliance.repair.bs.model.result;

/**
 * @desc 通用返回结果
 * @date 2019/04/10
 * @author caiyf
 */
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    private Result(T data) {
        this.code = CodeEnum.SUCCESS.getCode();
        this.msg = CodeEnum.SUCCESS.getMsg();
        this.data = data;
    }
    private Result(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }

    /**
     * 成功时返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> getSuccessResult(T data) {
        return new Result<T>(data);
    }

    /**
     * 异常时返回
     * @param codeEnum
     * @param <T>
     * @return
     */
    public static <T> Result<T> getExceptionResult(CodeEnum codeEnum) {
        return new Result<T>(codeEnum);
    }

}
