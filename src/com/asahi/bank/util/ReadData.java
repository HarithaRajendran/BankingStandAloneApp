package com.asahi.bank.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.asahi.bank.InstanceGivingClass;
import com.asahi.bank.entities.Account;
import com.asahi.bank.entities.User;
import com.asahi.bank.manager.AccountManager;
import com.asahi.bank.manager.UserManager;

public class ReadData {
	private static int count = 0;
	static String[] user = new String[100];
	static String[] account = new String[100];

	public static List<User> readUserData(String filename) {
		List<User> userList = new ArrayList<User>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {

			// Files.
			String line;

			while ((line = br.readLine()) != null) {
				user[count] = line;
				count++;
			}
			for (String s : user) {
				if (s != null) {
					String[] value = s.split("\t");
					userList.add(InstanceGivingClass.userManagerObject().createUser(Integer.parseInt(value[0]), value[1], value[2],Long.parseLong(value[3])));
				}
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userList;

	}

	public static List<Account> readAccountData(String filename) {
		List<Account> accountList = new ArrayList<Account>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {

			// Files.
			String line;

			while ((line = br.readLine()) != null) {
				account[count] = line;
				count++;
			}
			for (String s : account) {
				if (s != null) {
					String[] value = s.split("\t");
					accountList.add(InstanceGivingClass.accountManagerObject().createAccount(Long.parseLong(value[0]), value[1],
							Double.parseDouble(value[2]), Integer.parseInt(value[3])));
				}
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return accountList;

	}
}
