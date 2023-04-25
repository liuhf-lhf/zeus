package com.liuhf.user.service.zeususerserivce.config;

import com.liuhf.common.lang.exception.BusinessException;
import com.liuhf.common.lang.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liuhf
 * @date 2023/4/24
 * @since 1.0
 */
@RestControllerAdvice
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
    @ExceptionHandler(BusinessException.class)
    public Result<?> businessException(BusinessException ex){
        logger.error(ex.getMsg());
        ex.printStackTrace();
        return Result.failed(ex.getCode(),ex.getMsg());
    }

}
