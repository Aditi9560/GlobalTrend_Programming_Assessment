package com.example.logexecutiontime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.security.Signature;
	@Aspect
	@Component
	public class LogExecutionTimeProcessor {
	    @Around("@annotation(logExecutionTime)")
	    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
	        long startTime = System.currentTimeMillis();
	        Object proceed = joinPoint.proceed();
	        long executionTime = System.currentTimeMillis() - startTime;
	        Method method = getMethod(joinPoint);
	        System.out.println(method.getName() + " executed in " + executionTime + "ms");
	        return proceed;
	    }
	    private Method getMethod(ProceedingJoinPoint joinPoint) {
	        Signature signature = (Signature) joinPoint.getSignature();
	        MethodSignature methodSignature = (MethodSignature) signature;
	        return methodSignature.getMethod();
	    }
	}



