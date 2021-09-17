package com.Emp.training.aopDemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class Human {
//	@Before("MyPointCuts()")
//	public void wakeUp(JoinPoint j) {
//		System.out.println("good morning !!!!!!!!!!!!"+j.getTarget().getClass().getName());
//	}
//	@After("MyPointCuts()")
//	public void sleep() {
//		System.out.println("good night");
//	}
//	@Pointcut("execution(public * study*(..))")
//	public void MyPointCuts() {
//		
//	}
	@AfterReturning( pointcut="execution(* study*(..))",returning="value")
	public void wakeUp(int value) {
		System.out.println(" study* method return value "+value);
	}
	@AfterThrowing(pointcut="execution(* doOperation())",throwing="ex")
	public void wakeUp(MyException ex) {
		System.out.println("this is  throw exception ="+ ex);
	}
	
	@Around("execution(int rankOfVideo(int,int))")
	public Object aroundAdvice(ProceedingJoinPoint jp) {
		Object[] objArgs=jp.getArgs();
		objArgs[0]=	Integer.parseInt(objArgs[0]+"")-50;
		objArgs[1]=	Integer.parseInt(objArgs[1]+"")-20;
		Object res=null;
		try {
			res=jp.proceed(objArgs);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println(res);
		return res;
		
	}
	
	
}
