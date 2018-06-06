package com.asahi.bank;

import java.util.Scanner;

import com.asahi.bank.dao.UserAndAccountDao;

public class LaunchMiniBankApp //implements Runnable{
	
{	static Scanner scanner = new Scanner(System.in);
		static boolean toSwitch = false;

		public static void ToLoop() {
			do {
				System.out.println("\nEnter 1 to add \nEnter 2 to deposit or withdraw \nEnter 3 to exit");
				String choice = scanner.next();

				switch (choice) {
				case "1": {
					String userData = UserAndAccountDao.addData(scanner);
					String[] userData2 = userData.split("\t");
					String[] userType = userData2[1].split(",");

					String accountNo;
					if (userData2[2].length() > 23) {
						accountNo = userData2[2].substring(1, 23);
					} else {
						accountNo = userData2[2].substring(1, 11);
					}

					String[] accountNoOfAccount = accountNo.split(",");

					System.out.println("Welcome " + userData2[0]);
					for (String d : userType) {
						System.out.println("Your " + d + " is created successfully...");
					}
					int count = 0;
					for (String s : accountNoOfAccount) {
						System.out.println("Your Account No for " + userType[count] + " is " + s);
						count++;
					}
					System.out.println("Use the account number for Your Transcations...\nThank You...");
					break;
				}
				case "2": {
					System.out.println("Enter Your Account No");
					UserAndAccountDao.checkAccountDetails(scanner);
					break;
				}
				case "3": {
					toSwitch = true;
					break;
				}
				default: {
					System.out.println("Invalid Input...Try again");
					break;
				}
				}
			} while (!toSwitch);
			System.out.println("Thank you...");
		}
		

		/*public void run() {
			LaunchMiniBankApp.ToLoop();
		}*/
}
