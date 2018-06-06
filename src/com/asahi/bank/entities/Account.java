package com.asahi.bank.entities;

public abstract class Account{

	private Long accountNo;
	private String accountType;
	private double accountBalance;
	private int userId;

	public abstract void deposit(double amount, Account accountDetailOfCurrentUser);

	public abstract void withdraw(double amount, Account accountDetailOfCurrentUser);

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return accountNo + "	" + accountType + "	" + accountBalance + "	" + userId;
	}
}
