package com.asahi.bank;

import com.asahi.bank.dao.UserAndAccountDao;

public class MainClass 
{
	public static void main(String[] args) {
		UserAndAccountDao.readFromUser("user");
		UserAndAccountDao.readFromAccount("account");
		
	//	Thread r1 = new Thread(new LaunchMiniBankApp());
	//	Thread r2 = new Thread(new LaunchMiniBankApp());

		System.out.println("Welcome....!");
		
		 LaunchMiniBankApp.ToLoop();
		
	//	r1.start();
	//	r2.start();
		
	}
}
