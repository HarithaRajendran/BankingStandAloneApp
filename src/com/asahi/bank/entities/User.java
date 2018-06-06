package com.asahi.bank.entities;

import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component("user")
public class User {
	public User() {
	}

	private int id;
	private String username;
	private String accountType;
	private Long accountNo;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + "	" + username + "	" + accountType + "	" + accountNo;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

}
