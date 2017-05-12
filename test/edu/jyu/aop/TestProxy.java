package edu.jyu.aop;

import org.junit.Test;

import edu.jyu.core.BeanFactory;
import edu.jyu.core.ClassPathXmlApplicationContext;
import edu.jyu.dao.UserDao;

public class TestProxy {
	
	@Test
	public void testJDKProxy(){
		BeanFactory ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		UserDao userDao = (UserDao) ac.getBean("userDaoProxy");
		System.out.println(userDao.getClass());
		userDao.add("Jason");
		String user = userDao.getUser("132");
		System.out.println(user);
	}
}
