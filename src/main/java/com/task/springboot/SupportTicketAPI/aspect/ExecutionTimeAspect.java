package com.task.springboot.SupportTicketAPI.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Around("@annotation(com.task.springboot.SupportTicketAPI.annotation.LogExecutionTime)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {

         long startTime=System.currentTimeMillis();

         try{
             return joinPoint.proceed();

         }finally {
             long endTime=System.currentTimeMillis();

             System.out.println("Time Execution of Process: "+ (endTime-startTime) +"ms");
         }
     }
}
