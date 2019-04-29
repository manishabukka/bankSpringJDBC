package com.cg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.BankDao;
import com.cg.model.CustomerDetails;

@Transactional
@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	BankDao bankDao;
	public CustomerDetails register(CustomerDetails cd) {
		// TODO Auto-generated method stub
		return bankDao.register(cd);
	}
	public int login(CustomerDetails c) {
		// TODO Auto-generated method stub
		return bankDao.login(c);
	}


}
