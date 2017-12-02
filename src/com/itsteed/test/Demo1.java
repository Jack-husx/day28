package com.itsteed.test;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.itsteed.domain.Customer;
import com.itsteed.utils.HibernateUtils;

public class Demo1 {
	
	
	@Test
	public void testSave3(){
		Session session = null;
		Transaction tr = null;
		try {
			//获取session
			session = HibernateUtils.getSession();
			//开启事务
			tr = session.beginTransaction();
			//执行代码
			Customer c = new Customer();
			c.setCust_name("哈哈哈");
			//保存
			session.save(c);
			//提交事务
			tr.commit();
			
		} catch (Exception e) {
			//回滚事务
			tr.rollback();
			e.printStackTrace();
		} finally {
			
		}
	}

	/**
	 * 测试查询的方法
	 */
	
	@Test
	public void testSel() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//创建查询的接口
		Query query = session.createQuery("from Customer");
		//查询所有的数据 select * from 
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		//提交事务
		tr.commit();
		//释放资源
		session.close();
		
	}
	
	@Test
	public void testSaveOrUpdate() {
		/**
		 * 测试get方法
		 */
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//测试查询的方法2个参数：arg0查询JavaBean的class对象
		Customer c = new Customer();
		
		
		//设置用户的信息
//		c.setCust_name("小苍");
//		c.setCust_level("3");
//		
//		session.update(c);
		 //先查询再改
		
		
		tr.commit();
		session.close();
		
	}

	@Test
	public void testSave2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Customer c = new Customer();
		c.setCust_name("郭美美");
		tr.commit();
		session.save(c);
		//释放资源
		session.close();
		
	}
	
	/**
	 * 测试保存客户
	 * @throws SystemException 
	 * @throws RollbackException 
	 * @throws HeuristicRollbackException 
	 * @throws HeuristicMixedException 
	 * @throws SecurityException 
	 */
	@Test
	public void testSave() {
		/**
		 * 1.先加载配置文件
		 * 2.创建SessionFactory对象，生成Session对象
		 */
		//Configuration config = new Configuration();
		Configuration config = new Configuration().configure();
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = (Transaction) session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("测试10");
		c.setCust_level("2");
		c.setCust_phone("110");
		
		session.save(c);
		tr.commit();
		session.close();
		factory.close();
		
	}
}
