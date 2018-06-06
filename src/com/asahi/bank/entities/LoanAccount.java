package com.asahi.bank.entities;

import org.springframework.stereotype.Component;

@Component("loan account")
public class LoanAccount extends Account {

	@Override
	public synchronized void deposit(double amount, Account accountDetailOfCurrentUser) {
		System.out.println("In deposit of Loan Account...");
		if (amount < 50 || accountDetailOfCurrentUser.getAccountBalance() < amount) {
			System.out.println("You can deposit only more than Rs.50...");
		} else {
			accountDetailOfCurrentUser.setAccountBalance(accountDetailOfCurrentUser.getAccountBalance() - amount);
			System.out.println("Your Transcations is success.....");
		}
		System.out.println("Current Balance: " + accountDetailOfCurrentUser.getAccountBalance());

	}

	@Override
	public synchronized void withdraw(double amount, Account accountDetailOfCurrentUser) {
		System.out.println("In withdraw of Loan Account...");
		if (amount < 50) {
			System.out.println("Insufficient Balance...");
		} else {
			accountDetailOfCurrentUser.setAccountBalance(accountDetailOfCurrentUser.getAccountBalance() + amount);
			System.out.println("Your Transcations is success.....");
		}
		System.out.println("Current Balance: " + accountDetailOfCurrentUser.getAccountBalance());
	}
}
