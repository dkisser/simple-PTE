package org.wc.tools.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.wc.tools.web.model.ResultMsg;

/**
 * Created by WenChen on 2020/11/24.
 */
@RestControllerAdvice
public class ResponseProcessor implements ResponseBodyAdvice{
    private static final Logger logger = LoggerFactory.getLogger(ResponseProcessor.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !methodParameter.getParameterType().equals(ResultMsg.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getParameterType().equals(String.class)){
            ObjectMapper mapper = new ObjectMapper();
            try {
                serverHttpResponse.getHeaders().add(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE);
                return mapper.writeValueAsString(ResultMsg.success(o));
            } catch (JsonProcessingException e) {
                logger.error("响应异常",e);
            }
        }
        return ResultMsg.success(o);
    }
}
