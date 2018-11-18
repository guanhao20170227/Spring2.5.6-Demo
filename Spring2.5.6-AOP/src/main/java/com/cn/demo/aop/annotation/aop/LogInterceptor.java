package com.cn.demo.aop.annotation.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//aspect���������˼��@Aspect���ε���˵�������е��������
//ע�������౾��ҲҪʹ��@Component��ʼ��
@Aspect
@Component
public class LogInterceptor {
	//before����˼��˵�ڷ���ִ��֮ǰ��ִ�������
	//Ҫ������ҵ���߼�֯��ĳ�����ĳ��������
	//�Ǹ��������Spring����������
	//before���Լ����﷨����Ϊ֯����﷨
	//������������֯���ȥ�ˣ���ȷ�е�˵���н�ȥ
	
	
	@Before("execution(public * com.cn.demo.aop.annotation.dao.impl.UserDAOImpl.save(com.cn.demo.aop.annotation.model.User))")
	public void before() {
		System.out.println("method start...");
	}
	//2������������
	/*@Before("execution(public * com.dao..*.*(..))")
	public void before() {
		System.out.println("method start...");
	}*/
	//3: afterreturning ��ʾ��������ִ�з���
	/*@Before("execution(public * com.dao..*.*(..))")
	public void before() {
		System.out.println("method start...");
	}
	
	@AfterReturning("execution(public * com.dao..*.*(..))")
	public void after() {
		System.out.println("method end...");
	}*/
	
	//4:�ȽϹ�����﷨��Poingcut�൱��һ�������ļ��ϣ�myMethod�൱�ڸ����
	//�������˸����֣�ûʲô����ɽ�
	/*@Pointcut("execution(public * com.dao..*.*(..))")
	public void myMethod() {}
	
	@Before("myMethod()")
	public void before() {
		System.out.println("method start...");
	}
	
	@AfterReturning("myMethod()")
	public void after() {
		System.out.println("method  afterreturning...");
	}*/
	
	//5: ����@AfterThrowing
	/*@Pointcut("execution(public * com.dao..*.*(..))")
	public void myMethod() {}
	
	@Before("myMethod()")
	public void before() {
		System.out.println("method start...");
	}
	
	@AfterThrowing("myMethod()")
	public void after() {
		System.out.println("method after throwing...");
	}*/
	//6:around
	/*@Pointcut("execution(public * com.dao..*.*(..))")
	public void myMethod() {}
	
	@Before("myMethod()")
	public void before() {
		System.out.println("method start...");
	}
	
	@Around("myMethod()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("method around start...");
		pjp.proceed();
		System.out.println("method around end...");
	}*/
	//7:��ҵ���߼�֯��ҵ���
	//ע��UserServiceû��ʵ�ֽӿڣ������ʵ���˽ӿڣ�ϵͳ��ʹ��JDK�Դ���invocationhandler
	//����������������Ҫ�ö����Ƶ���ʽ���ܲ�����������������Ҫ����
	/*@Pointcut("execution(public * com.service..*.add(..))")
	public void myMethod() {}*/
	
	/*@Before("myMethod()")
	public void before() {
		System.out.println("method start...");
	}*/
	
	/*@Around("myMethod()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("method around start...");
		pjp.proceed();
		System.out.println("method around end...");
	}*/
	
}
