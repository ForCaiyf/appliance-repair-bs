package com.caiyf.appliance.repair.bs.exception;

import com.caiyf.appliance.repair.bs.model.result.CodeEnum;
import com.caiyf.appliance.repair.bs.model.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @desc 异常处理器
 * @date 2019/04/10
 * @author caiyf
 */
@ControllerAdvice
public class ExceptionHandle {

    /**
     * 处理异常
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {
        // 自定义异常
        if (e instanceof BusinessException) {
            return Result.getExceptionResult(((BusinessException) e).getCodeEnum());
        }
        return Result.getExceptionResult(CodeEnum.UNKNOWN_ERROR);
    }

}
