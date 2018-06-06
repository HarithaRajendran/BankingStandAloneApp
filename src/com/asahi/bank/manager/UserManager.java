package com.asahi.bank.manager;

import com.asahi.bank.manager.UserManager;

import org.springframework.stereotype.Component;

import com.asahi.bank.InstanceGivingClass;
import com.asahi.bank.entities.User;

@Component("userManager")
public class UserManager {
	//private static UserManager instance = InstanceGivingClass.userManagerObject();

	public UserManager() {

	}

/*	public static UserManager getInstance() {
		return instance;
	}*/

	public User createUser(int id, String username, String accountType,Long accountNo) {
		User user = InstanceGivingClass.userObject();

		user.setId(id);
		user.setUsername(username);
		user.setAccountType(accountType);
		user.setAccountNo(accountNo);
		return user;
	}
}
