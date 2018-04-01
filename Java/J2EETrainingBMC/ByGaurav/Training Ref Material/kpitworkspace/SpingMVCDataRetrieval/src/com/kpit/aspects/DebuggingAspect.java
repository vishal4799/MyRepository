package com.kpit.aspects;

import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.servlet.ModelAndView;

@Aspect
public class DebuggingAspect {
	
	
	@Before("execution(* com.kpit.*.*.*(..))")
	public void beforeMethod(JoinPoint point){
		System.out.println("Before Advice Method:"+ point.getSignature().getName()+" was called at "+new Date());
		
	
	}
	@After("execution(* com.kpit.*.*.*(..))")
	public void afterMethod(JoinPoint point){
		
		System.out.println("After Advice Method:"+ point.getSignature().getName()+" completed "+new Date());
	}
	@AfterThrowing(
		      pointcut = "execution(* com.kpit.*.*.*(..))",
		      throwing= "error")
	public void afterThrowing(JoinPoint point,Throwable error){
		
		System.out.println("After throwing method:"+" threw exception "+error.getMessage());
		
		
		
	}
	@AfterReturning(pointcut ="execution(* com.kpit.controller.*.*(..))",
		      returning= "result")
	public void afterReturning(JoinPoint point,Object result){
		
		if(result instanceof ModelAndView){
			ModelAndView mv=(ModelAndView)result;
			System.out.println("View name set in ModelAndView is:"+mv.getViewName());
		}
		
	}
	
	@Pointcut("execution(* com.kpit.*.*.*(..))")
	public void getPointCut(){
			
	}
	
	@Around("getPointCut()")
	public Object aroundMethod(ProceedingJoinPoint point) throws Throwable{
		
		System.out.println("Around advice applied");
		Object returnedValue=point.proceed();
		System.out.println("Method Returned:"+returnedValue);
		return returnedValue;
		
	}
	
}
