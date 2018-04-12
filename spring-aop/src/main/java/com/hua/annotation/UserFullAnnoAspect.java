/**
  * @filename UserFullAnnoAspect.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;

import com.hua.bean.User;

 /**
 * @type UserFullAnnoAspect
 * @description  
 * @author qye.zheng
 */
// 该类对象需要被代理，因此不能声明为final
@Aspect
public class UserFullAnnoAspect {
	
	/**
	 * 
	 * @description 方法无意义，只是用来装载pointcut逻辑
	 * 相当于<aop:pointcut id="userBusinessCut" expression="execution(* com.hua.service.*.*(..))" />
	 * 任何使用了该切入点的通知，必须声明为 pointcut = "userBusinessCut(user)" 且方法参数中必须
	 * 含有该参数(这里是user参数)
	 * @author qye.zheng
	 */
	// 在注解中逻辑运算符 使用 && 不会报错，使用 and就不会报错，而xml配置中恰恰相反
	@Pointcut("execution(* com.hua.service.*.*(com.hua.bean.User,..)) && args(user,..)")
	public void userBusinessCut(final User user) {}
	
	/**
	 * 任何通知 方法都可以将第一个参数定义为org.aspectj.lang.JoinPoint类型
	 * (org.aspectj.lang.ProceedingJoinPoint 是其子类，给around方法调用目标方法作用)
	 */
	
	/**
	 * 
	 * @description 
	 * @param joinPoint
	 * @author qye.zheng
	 */
	public void advice(final JoinPoint joinPoint)
	{
		// 获取代理对象
		Object _this = joinPoint.getThis();
		// 获取目标对象
		Object target = joinPoint.getTarget();		
		// 获取方法参数值
		Object[] args = joinPoint.getArgs();
		// 方法签名
		Signature sn = joinPoint.getSignature();
		StaticPart staticPart = joinPoint.getStaticPart();
		String kind = joinPoint.getKind();
		// 源码位置 对象
		SourceLocation sourceLocation = joinPoint.getSourceLocation();
		
		String longString = joinPoint.toLongString();
		String shortString = joinPoint.toShortString();
		
		// 输出方法路径
		System.out.println("begining method: " + joinPoint.getTarget().getClass().getName() 
				+ "." + joinPoint.getSignature().getName());
	}
	
	/**
	 * 
	 * @description 
	 * @param joinPoint
	 * @author qye.zheng
	 */
	/*
	 * 	<aop:pointcut id="userBusinessCut" expression="execution(* com.hua.service.*.*(com.hua.bean.User,..)) and args(user)" />
	 * <aop:before pointcut-ref="userBusinessCut" method="doBefore" arg-names="user"/>
	 * 这样配置 才能正确注入值
	 */
	//public void doBefore(final User user)
	// 暂时实现不了
	//public void doBefore(final String msg)
	// 这种方式是不行的: @Before(value = "userBusinessCut", argNames = "user")
	@Before(value = "userBusinessCut(user)")
	public void doBefore(final JoinPoint joinPoint, final User user)
	{
		// 输出方法路径
		System.out.println("begining method: " + joinPoint.getTarget().getClass().getName() 
				+ "." + joinPoint.getSignature().getName());
		System.out.println("arg: " + joinPoint.getArgs()[0].toString());
		// 输出绑定的参数
		System.out.println(user.toString());
	}
	
	/**
	 * around 可以覆盖 before / returning / throwing / after 场景，因此，
	 * around 要独立使用，尽量不要合在一起使用，不然很难区分各个通知的职责
	 */
	/**
	 * 
	 * @description 
	 * @param pJoinPoint
	 * @return
	 * @throws Throwable
	 * @author qye.zheng
	 */
	//@org.aspectj.lang.annotation.Around(value = "userBusinessCut(user)")
	public Object doAround(final ProceedingJoinPoint pJoinPoint, final User user) throws Throwable
	{
		// before
		long time = System.currentTimeMillis();
		
		// 执行 目标的方法
		Object result = null;
		try {
			result = pJoinPoint.proceed();
			// returning
		} catch (Exception e) {
			// throwing
			e.printStackTrace();
		}
		
		// after
		
		time = System.currentTimeMillis() - time;
		System.out.println("process time: " + time + " ms");
		
		return result;
	}
	
	/**
	 * 
	 * @description 
	 * @param joinPoint
	 * @param throwable
	 * @author qye.zheng
	 */
	@AfterThrowing(pointcut = "userBusinessCut(user)", throwing = "throwable")
	public void doThrowing(final JoinPoint joinPoint, final Throwable throwable, final User user)
	{
		System.out.println("method: " + joinPoint.getTarget().getClass().getName() 
				+ "." + joinPoint.getSignature().getName() + " throw exception ");
		// 输出异常信息
		throwable.printStackTrace();
	}
	
	/**
	 * 
	 * @description 
	 * @param joinPoint
	 * @param returning
	 * @author qye.zheng
	 */
	@AfterReturning(pointcut = "userBusinessCut(user)", returning = "returning")
	public void doReturning(final JoinPoint joinPoint, final Object returning, final User user)
	{
		//System.out.println("return: " + returning.toString());
	}
	
	/**
	 * 
	 * @description 
	 * @param joinPoint
	 * @author qye.zheng
	 */
	@After(value = "userBusinessCut(user)")
	public void doAfter(final JoinPoint joinPoint, final User user)
	{
		System.out.println("ending method: " + joinPoint.getTarget().getClass().getName() 
				+ "." + joinPoint.getSignature().getName());
	}
	
}
