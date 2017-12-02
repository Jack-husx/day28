package com.itsteed.service;

import com.itsteed.dao.CustomerDao;
import com.itsteed.domain.Customer;

public class CustomerService {
	
	/**
	 * 保存客户
	 * @param c
	 */
	public void saveCustomer(Customer c){
		new CustomerDao().save(c);
	}

}
