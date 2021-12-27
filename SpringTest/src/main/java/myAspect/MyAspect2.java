package myAspect;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect2 {
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void beforeLogAdvice(JoinPoint joinPoint) {
		logger.log(Level.INFO,
				"目標物件方法執行之前的日誌紀錄(method starts)......"
				+joinPoint.getSignature().getDeclaringTypeName()
				+"."
				+joinPoint.getSignature().getName()
				);
		System.out.println("Hi I'm beforeLogAdvice ");
	}
	
	public void afterReturningLogAdvice(JoinPoint joinPoint,Object returnValue) {
		logger.log(Level.INFO,
				"目標物件方法執行之後的日誌紀錄(method ends)......"
				+joinPoint.getSignature().getDeclaringTypeName()
				+"."
				+joinPoint.getSignature().getName()
				);
	}
	
	public void afterThrowingLogAdvice(JoinPoint joinPoint, Throwable throwable) {
		logger.log(Level.INFO,
				"目標物件方法執行時發生例外的日誌紀錄(method throws Expection)......" + joinPoint.getSignature().getDeclaringTypeName()
//				+ joinPoint.getTarget().getClass().getName()
						+ "." + joinPoint.getSignature().getName() + "Exception的型態為:" + throwable);
	}

//	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//		logger.log(Level.INFO, "目標物件方法執行之前的日誌紀錄(method starts)......" + joinPoint.getSignature().getDeclaringTypeName()
//				+ joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
//
//		Object returnValue = joinPoint.proceed();
//
//		logger.log(Level.INFO, "目標物件方法執行之後的日誌紀錄(method ends)......" + joinPoint.getSignature().getDeclaringTypeName()
////				+ joinPoint.getTarget().getClass().getName()
//				+ "." + joinPoint.getSignature().getName());
//
//		return returnValue;
//	}
	
}
