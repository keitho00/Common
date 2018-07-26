package com.code.common.web.domain.aspect;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Author: wanghao
 * @Date: 2018/4/19 13:22
 */
@Component
@Aspect
@Slf4j
public class ControllerInvokeAspect {

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)||@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String tempFunctionName = joinPoint.getSignature().toShortString();
        String functionName = tempFunctionName.substring(0, tempFunctionName.length() - 4);
        Object[] objects = joinPoint.getArgs();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        String description = "";
        if (!Objects.isNull(apiOperation)) {
            description = apiOperation.value();
        }
        log.info("{}|{}|param:{}", functionName, description, objects);
        return joinPoint.proceed(objects);
    }
}
