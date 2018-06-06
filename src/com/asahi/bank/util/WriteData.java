package com.asahi.bank.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import com.asahi.bank.entities.Account;
import com.asahi.bank.entities.User;

public class WriteData {
	public static void writeToUserFile(String fileName, List<User> user) {
		try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {

			for (User str1 : user) {
				br.write(str1.toString() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeToAccountFile(String fileName, List<Account> account) {
		try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {

			for (Account str1 : account) {
				br.write(str1.toString() + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
