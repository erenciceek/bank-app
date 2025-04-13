package com.banking.core.crosscuttingconcerns.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.banking.core.constants.Messages;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(pointcut = Messages.Logging.EXECUTION_POINTCUT, throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error(Messages.Logging.EXCEPTION_MESSAGE, 
            joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(),
            exception.getCause() != null ? exception.getCause() : Messages.Logging.NULL_CAUSE);
    }
} 