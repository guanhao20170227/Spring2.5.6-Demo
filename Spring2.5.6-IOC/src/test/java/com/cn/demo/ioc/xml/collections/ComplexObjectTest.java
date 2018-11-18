package com.cn.demo.ioc.xml.collections;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * �����Լ���ĺð�
 * @author wanglf1207
 *
 */
public class ComplexObjectTest {

	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-ioc-collections.xml");
		ComplexObject complexObject = (ComplexObject) applicationContext.getBean("complexObject");
		
		System.out.println(complexObject.getAdminEmails());
		
		System.out.println(complexObject.getSomeList());
	}

}
