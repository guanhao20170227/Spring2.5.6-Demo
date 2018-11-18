package com.cn.demo.ioc.xml.lifecycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LifeCycleExampleTest {

	@Test
	public void test() {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-ioc-lifecycle.xml");
		
		applicationContext.getBeanDefinitionCount();
		
		/*
		 * ApplicationContext��û��destroy����
		 * web���������ʱ����Զ�����destroy����������ֻ��ģ��
		 */
		applicationContext.destroy();
		
	}

}
