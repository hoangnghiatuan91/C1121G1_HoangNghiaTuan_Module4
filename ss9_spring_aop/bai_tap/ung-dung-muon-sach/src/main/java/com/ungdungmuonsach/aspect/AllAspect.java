package com.ungdungmuonsach.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AllAspect {
    private static Integer numberOfVisitor = 0;

    @After("execution(* com.ungdungmuonsach.controller.BookController(..))")
    public void logBook(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("class name : " + className);
        System.out.println("method : " + methodName);
        System.out.println(" args : " + args);
    }

    @After("execution(* com.ungdungmuonsach.controller.BookBorrowController(..))")
    public void logBorrowAndReturnBook(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("class name : " + className);
        System.out.println("method : " + method);
        System.out.println("args : " + args);
    }

    @AfterReturning(pointcut = "execution(public * com.ungdungmuonsach.controller.BookController.*(..))")
    public void logViewers(JoinPoint joinPoint) {
        numberOfVisitor += 1;
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("class name : " + className);
        System.out.println("method : " + method);
        System.out.println("args : " + args);
        System.out.println("views : " + numberOfVisitor);
    }
}