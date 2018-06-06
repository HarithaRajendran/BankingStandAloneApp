package com.asahi.bank.manager;

import org.springframework.stereotype.Component;

import com.asahi.bank.entities.Account;
import com.asahi.bank.entities.LoanAccount;
import com.asahi.bank.entities.SavingsAccount;

@Component("accountManager")
public class AccountManager {
	//private static AccountManager instance = new AccountManager();

	private AccountManager() {

	}

	/*public static AccountManager getInstance() {
		return instance;
	}*/

	public Account createAccount(long accountNo, String accountType, double accountBalance, int userId) {

		if (accountType.equalsIgnoreCase("savings account")) {
			Account saccount = new SavingsAccount();
			saccount.setAccountNo(accountNo);
			saccount.setAccountType(accountType);
			saccount.setAccountBalance(accountBalance);
			saccount.setUserId(userId);
			return saccount;
		} else {
			Account laccount = new LoanAccount();
			laccount.setAccountNo(accountNo);
			laccount.setAccountType(accountType);
			laccount.setAccountBalance(accountBalance);
			laccount.setUserId(userId);
			return laccount;
		}
	}
}
