package com.nttdata.EmployeePortal.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import org.aspectj.lang.reflect.MethodSignature;

@Aspect
@Component
public class EmployeeLoggingAspect {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeLoggingAspect.class);
	
	@Around("execution(* com.nttdata.EmployeePortal..*(..)))")
	public Object employeePortalMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		
		MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
		
		String className= methodSignature.getDeclaringType().getSimpleName();
		String methodName= methodSignature.getName();
		
		final StopWatch stopWatch = new StopWatch();
        
        //Measure method execution time
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
  
        //Log method execution time
        LOGGER.info("Execution time of " + className + "." + methodName + " "
                            + ":: " + stopWatch.getTotalTimeMillis() + " ms");
		return result;
	}
}
