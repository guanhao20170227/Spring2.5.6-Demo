package com.cn.demo.aop.principle;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.cn.demo.aop.principle.aop.LogInterceptor;
import com.cn.demo.aop.principle.dao.UserDAO;
import com.cn.demo.aop.principle.dao.impl.UserDAOImpl;
import com.cn.demo.aop.principle.model.User;
import com.cn.demo.aop.principle.service.UserService;
import com.cn.demo.aop.principle.spring.BeanFactory;
import com.cn.demo.aop.principle.spring.ClassPathXmlApplicationContext;

public class UserServiceTest {
	
	@Test
	public void testAdd() throws Exception {
		BeanFactory applicationContext = new ClassPathXmlApplicationContext();
		UserService service = (UserService)applicationContext.getBean("userService");
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");
		service.add(u);
	}
	
	@Test
	public void testProxy() throws Exception {
		UserDAO userDAO = new UserDAOImpl();
		// ��UserDAO����������Ķ���
		LogInterceptor li = new LogInterceptor();
		li.setTarget(userDAO);
		/*
		 * ���ݱ�����������һ������
		 * ����˵����loader�����ĸ�classloader�����������Ҫ�ͱ����������ͬһ��classLoder
		 * interfaces:�����ı��������Ҫʵ����Щ�ӿ�
		 * h:���ĸ�handler���д���
		 * ע�⣺�ӿ�interfaces������Щ���������ɴ����������Щ����
		 * �����еķ���ÿһ�α����õ�ʱ�򶼻ᴫ��InvocationHandler
		 * Ҳ���Ǵ���public Object invoke(Object proxy, Method method, Object[] args)
		 * ����ָ��interfaces�����ַ�ʽ����
		 */
		ClassLoader loader = userDAO.getClass().getClassLoader();
		//Class[] interfaces = new Class[]{UserDAO.class};
		@SuppressWarnings("rawtypes")
		Class[] interfaces = userDAO.getClass().getInterfaces();
		UserDAO userDAOProxy = (UserDAO) Proxy.newProxyInstance(loader, interfaces, li);
		// ��ӡ���������
		//System.out.println(userDAOProxy.getClass().getName());
		userDAOProxy.save(new User());
		userDAOProxy.delete();
		
		//��������ĵ������Ĵ���Ϊ
		/*class $Proxy4 implements UserDAO 
		 * {
		 * 	save(User u) {
		 * 	Method m = UserDAO.getclass.getmethod 
		 * li.invoke(this, m, u)
		 * }
		 * }
		 */

	}
}
