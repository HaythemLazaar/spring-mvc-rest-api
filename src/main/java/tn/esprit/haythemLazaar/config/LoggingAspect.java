package tn.esprit.haythemLazaar.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @After("execution(* tn.esprit.haythemLazaar.services.*.*(..))")
    public void logExecution(JoinPoint joinPoint) {
        // Log message
        logger.info("Method executed" + joinPoint.getSignature().getName());
    }
}
