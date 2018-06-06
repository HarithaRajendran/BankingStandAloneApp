package com.asahi.bank.entities;

import org.springframework.stereotype.Component;

@Component("savings account")
public class SavingsAccount extends Account {

	@Override
	public synchronized void deposit(double amount, Account accountDetailOfCurrentUser) {
		System.out.println("In deposit of Savings Account...");
		if (amount < 50) {
			System.out.println("You can deposit only more than Rs.50...");
		} else {
			accountDetailOfCurrentUser.setAccountBalance(accountDetailOfCurrentUser.getAccountBalance() + amount);
			System.out.println("Your Transcations is success.....");
		}
		System.out.println("Current Balance: " + accountDetailOfCurrentUser.getAccountBalance());
	}

	@Override
	public synchronized void withdraw(double amount, Account accountDetailOfCurrentUser) {
		System.out.println("In withdraw of Savings Account...");
		if (amount < 50 || accountDetailOfCurrentUser.getAccountBalance() < amount) {
			System.out.println("Insufficient Amount...");
		} else {
			accountDetailOfCurrentUser.setAccountBalance(accountDetailOfCurrentUser.getAccountBalance() - amount);
			System.out.println("Your Transcations is success.....");
		}
		System.out.println("Current Balance: " + accountDetailOfCurrentUser.getAccountBalance());
	}

}
