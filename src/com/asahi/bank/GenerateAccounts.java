package com.asahi.bank;

import com.asahi.bank.entities.Account;

public class GenerateAccounts/*<T extends Account>*/{
	private Account instanceOfAccountType;

	public Account getInstanceOfAccountType() {
		return instanceOfAccountType;
	}

	/*public T getInstanceOfAccountType() {
		return instanceOfAccountType;
	}

	public void setInstanceOfAccountType(T instanceOfAccountType) {
		this.instanceOfAccountType = instanceOfAccountType;
	}*/

	public GenerateAccounts() {
	}

	public GenerateAccounts(Account object) {
		this.instanceOfAccountType = object;
	}
	
	public void withdraw(double amount, Account accountDetailOfCurrentUser) {
		this.instanceOfAccountType.withdraw(amount, accountDetailOfCurrentUser);
	}

	public void deposit(double amount, Account accountDetailOfCurrentUser) {
		this.instanceOfAccountType.deposit(amount, accountDetailOfCurrentUser);
	}
}