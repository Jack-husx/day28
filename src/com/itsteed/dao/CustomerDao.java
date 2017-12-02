package com.itsteed.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itsteed.domain.Customer;
import com.itsteed.utils.HibernateUtils;

public class CustomerDao {
	
	public void save(Customer c){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		session.save(c);
		
		tr.commit();
		session.close();
		
	
		
	}

}
