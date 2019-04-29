package com.cg.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cg.model.CustomerDetails;
import com.cg.utility.Database;

@Repository
public class BankDaoImpl implements BankDao {
	Database d = new Database();
	public CustomerDetails register(CustomerDetails cd) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("hibernate.cfg.xml");
		Session session = d.getSession();
    	Transaction transaction = session.beginTransaction();
    	session.persist(cd);
    	transaction.commit();
    	session.close();
		return cd;
	}
	public int login(CustomerDetails c) {
		
		int accountNo = 0;
		//ApplicationContext context=new ClassPathXmlApplicationContext("hibernate.cfg.xml");		
		Session session=d.getSession();
		CustomerDetails customerDetails = session.get(CustomerDetails.class, c.getAccountNo());
		if(customerDetails.getPassword().equals(c.getPassword())) {
			accountNo = c.getAccountNo(); 
		}
		return accountNo;
	}

	

}
