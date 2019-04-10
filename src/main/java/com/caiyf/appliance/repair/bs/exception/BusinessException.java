package com.caiyf.appliance.repair.bs.exception;

import com.caiyf.appliance.repair.bs.model.result.CodeEnum;
import lombok.Getter;

/**
 * @desc 自定义异常
 * @date 2019/04/10
 * @author caiyf
 */
@Getter
public class BusinessException extends RuntimeException {

    private CodeEnum codeEnum;

    public BusinessException(CodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.codeEnum = codeEnum;
    }
    public BusinessException(CodeEnum codeEnum, Throwable cause) {
        super(codeEnum.getMsg(), cause);
        this.codeEnum = codeEnum;
    }

}
