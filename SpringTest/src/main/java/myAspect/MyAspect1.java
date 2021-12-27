package myAspect;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect1 {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
//	@Pointcut("execution(* myBean.Ihello.get*(..))")
	@Pointcut("execution(String myBean.IHello.getName())")
	private void getName() {}
	
//	@Before("getName()")
//	public void beforeLogAdvice(JoinPoint joinPoint) {
//		logger.log(Level.INFO,
//				"目標物件方法執行之前的日誌紀錄(method starts)......"
//				+ joinPoint.getSignature().getDeclaringTypeName()
//				+ joinPoint.getTarget().getClass().getName()
//				+ "."
//				+ joinPoint.getSignature().getName());
//	}
//	
//	@AfterReturning(pointcut ="getName()",returning = "returnValue")
//	public void afterReturningLogAdvice(JoinPoint joinPoint,Object returnValue) {
//		logger.log(Level.INFO,
//				"目標物件方法執行之後的日誌紀錄(method ends)......"
//				+ joinPoint.getSignature().getDeclaringTypeName()
////				+ joinPoint.getTarget().getClass().getName()
//				+ "."
//				+ joinPoint.getSignature().getName());
//	}
	
	@AfterThrowing(pointcut ="getName()",throwing = "throwable")
	public void afterThrowingLogAdvice(JoinPoint joinPoint,Throwable throwable) {
		logger.log(Level.INFO,
				"目標物件方法執行時發生例外的日誌紀錄(method throws Expection)......"
				+ joinPoint.getSignature().getDeclaringTypeName()
//				+ joinPoint.getTarget().getClass().getName()
				+ "."
				+ joinPoint.getSignature().getName()
				+ "Exception的型態為:"+throwable);
	}
	
	@Around("getName()")
	public Object around(ProceedingJoinPoint joinPoint)throws Throwable {
		logger.log(Level.INFO,
				"目標物件方法執行之前的日誌紀錄(method starts)......"
				+ joinPoint.getSignature().getDeclaringTypeName()
				+ joinPoint.getTarget().getClass().getName()
				+ "."
				+ joinPoint.getSignature().getName());
		
		Object returnValue = joinPoint.proceed();
		
		logger.log(Level.INFO,
				"目標物件方法執行之後的日誌紀錄(method ends)......"
				+ joinPoint.getSignature().getDeclaringTypeName()
//				+ joinPoint.getTarget().getClass().getName()
				+ "."
				+ joinPoint.getSignature().getName());
		
		return returnValue;
	}
}
