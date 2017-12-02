package com.itsteed.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itsteed.domain.Customer;
import com.itsteed.service.CustomerService;

/**
 * Servlet implementation class SaveCustomer
 */
public class SaveCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收请求的参数
		request.setCharacterEncoding("UTF-8");
		Map<String,String[]> map = request.getParameterMap();
		Customer c = new Customer();
		try {
			BeanUtils.populate(c, map);
			new CustomerService().saveCustomer(c);
			System.out.println("添加客户成功了！");
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     doGet(request, response);
	}

}
