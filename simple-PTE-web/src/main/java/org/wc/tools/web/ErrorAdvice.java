package org.wc.tools.web;

import org.apache.dubbo.rpc.RpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.wc.tools.web.exception.BusinessException;
import org.wc.tools.web.model.ResultMsg;

/**
 * Created by WenChen on 2020/11/23.
 */
@RestControllerAdvice
public class ErrorAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ErrorAdvice.class);

    @ExceptionHandler({BusinessException.class})
    public ResultMsg businessHandler(BusinessException e){
        logger.error("业务异常",e);
        return ResultMsg.success(String.format("业务异常：[%s]%s",e.getCode(),e.getMsg()));
    }

    @ExceptionHandler({RuntimeException.class})
    public ResultMsg runtimeHandler(RuntimeException e){
        logger.error("未知异常",e);
        return ResultMsg.fail(String.format("系统异常：%s",e.getMessage()));
    }

    @ExceptionHandler({RpcException.class})
    public ResultMsg rpcRuntimeHandler(RpcException e){
        logger.error("rpc调用异常",e);
        return ResultMsg.fail("服务异常，请联系管理员");
    }

    @ExceptionHandler({Exception.class})
    public ResultMsg errorHandler(Exception e){
        logger.error("系统异常",e);
        return ResultMsg.fail("系统异常，请联系管理员");
    }

}
