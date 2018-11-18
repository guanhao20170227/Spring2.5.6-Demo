package com.cn.demo.aop.xml.dao.impl;

import org.springframework.stereotype.Component;

import com.cn.demo.aop.xml.dao.UserDAO;
import com.cn.demo.aop.xml.model.User;

@Component("u") 
public class UserDAOImpl implements UserDAO {

	public void save(User user) {
		System.out.println("user saved!");
		// �쳣һ����struts2������
		//throw new RuntimeException("exception!");
	}

}
