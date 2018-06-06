package com.asahi.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asahi.bank.entities.Account;
import com.asahi.bank.entities.LoanAccount;
import com.asahi.bank.entities.SavingsAccount;
import com.asahi.bank.entities.User;
import com.asahi.bank.manager.AccountManager;
import com.asahi.bank.manager.UserManager;

public class InstanceGivingClass {

	public static User userObject() {
		/*
		 * ClassPathXmlApplicationContext context = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); User theUser =
		 * (User) context.getBean("user",User.class);
		 * 
		 * context.close();
		 * 
		 * return theUser;
		 */

		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("applicationContext.xml");

		ApplicationContext context = 
		    	   new ClassPathXmlApplicationContext("applicationContext.xml");
		
		User theUser = (User) context.getBean("user", User.class);

		//context.close();

		return theUser;
	}

	public static UserManager userManagerObject() {
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserManager theUserManager = context.getBean("userManager", UserManager.class);
		context.close();

		return theUserManager;*/
		
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("applicationContext.xml");
		ApplicationContext context = 
		    	   new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserManager theUserManager = context.getBean("userManager", UserManager.class);
//		context.close();

		return theUserManager;
	}

	public static AccountManager accountManagerObject() {
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountManager theAccountManager = context.getBean("accountManager", AccountManager.class);
		context.close();

		return theAccountManager;*/
		
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("applicationContext.xml");
		
		ApplicationContext context = 
		    	   new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountManager theAccountManager = context.getBean("accountManager", AccountManager.class);
		
		
		//context.close();

		return theAccountManager;
	}

	public static GenerateAccounts generateAccountType(String accountType) {

		System.out.println("fghjghcd" + accountType);
		if (accountType.startsWith("sav")) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			GenerateAccounts theGenerateAccountType = context.getBean("mySavingsAccount", GenerateAccounts.class);
			context.close();

			return theGenerateAccountType;

		} else {

			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			GenerateAccounts theGenerateAccountType = context.getBean("myLoanAccount", GenerateAccounts.class);
			context.close();

			return theGenerateAccountType;
		}
	}

	/*public static Account account(String accountType) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Account theAccount = context.getBean(accountType, Account.class);
		context.close();

		return theAccount;
	}*/
}
