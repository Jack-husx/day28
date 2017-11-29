package com.itsteed.test;


import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.itsteed.domain.Customer;

public class Demo1 {


	/**
	 * 测试保存客户
	 * @throws SystemException 
	 * @throws RollbackException 
	 * @throws HeuristicRollbackException 
	 * @throws HeuristicMixedException 
	 * @throws SecurityException 
	 */
	@Test
	public void testSave() throws SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException, SystemException{
		/**
		 * 1.先加载配置文件
		 * 2.创建SessionFactory对象，生成Session对象
		 */
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = (Transaction) session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("测试");
		c.setCust_level("2");
		c.setCust_phone("110");
		
		
		tr.commit();
		session.close();
		factory.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
