package com.itsteed.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hibernate工具类
 * @author Admin
 *
 */
public class HibernateUtils {
	
	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY;
	
	static{
		//加载XML的配置文件
		CONFIG = new Configuration().configure();
		//构造工厂
		FACTORY = CONFIG.buildSessionFactory();
	}
	
	public static Session getSession(){
		return FACTORY.openSession();
	}
}
