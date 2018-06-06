package com.asahi.bank.dao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.asahi.bank.GenerateAccounts;
import com.asahi.bank.InstanceGivingClass;
import com.asahi.bank.LaunchMiniBankApp;
import com.asahi.bank.entities.Account;
import com.asahi.bank.entities.User;
import com.asahi.bank.manager.AccountManager;
import com.asahi.bank.manager.UserManager;
import com.asahi.bank.util.ReadData;
import com.asahi.bank.util.WriteData;

public class UserAndAccountDao {

	private static List<User> users = new ArrayList<>();
	private static List<Account> account = new ArrayList<>();

	private static Integer id;
	private static Long accountNo;
	private static Long accountNo1;

	/*--TO INSERT DATA--*/
	public static String addData(Scanner scanner) {
		id = ((users.get(users.size()-1)).getId()) + 1;
		accountNo = (account.get(account.size()-1).getAccountNo()) + 1;
		accountNo1 = (account.get(account.size()-1).getAccountNo()) + 1;

		System.out.println("Enter Name:");
		String username = scanner.next();
		System.out.println("select the account you want\n");
		String accountType = accountType(scanner);
		String[] accountTypes1 = accountType.split(",");

		String initialBalance = null;
		Pattern pattern = Pattern.compile(".*[^0-9 + .].*");
		System.out.println("Enter Initial Balance");
		initialBalance = scanner.next();
		while(pattern.matcher(initialBalance).matches()) {
			
			do {
				try {
					System.out.println("Invalid amount type");
					System.out.println("Enter Initial Balance");
					initialBalance = scanner.next();
					if (!pattern.matcher(initialBalance).matches()) {
						if(Double.parseDouble(initialBalance) < 500.00 ) {
							System.out.println("Minimum amount to pay initially is Rs.500.00");
						}
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input");
					System.exit(0);
				}
			} while (pattern.matcher(initialBalance).matches() || Double.parseDouble(initialBalance) < 500.00);
		}
		

		List<Long> accountNoArrayInUser = new ArrayList<>();
		for (String acc : accountTypes1) {
			users.add(InstanceGivingClass.userManagerObject().createUser(id, username, acc, accountNo1));
			accountNoArrayInUser.add(accountNo1);
			writeToUser("user");
			accountNo1++;
		}

		String[] accType = accountType.split(",");
		List<Long> accountNoArray = new ArrayList<>();
		for (String a : accType) {
			account.add(InstanceGivingClass.accountManagerObject().createAccount(accountNo, a, Double.parseDouble(initialBalance), id));
			writeToAccount("account");
			accountNoArray.add(accountNo);
			accountNo++;
		}

		return username + "\t" + accountType + "\t" + accountNoArray;
	}

	/* TO RETURN THE ACCOUNT TYPE */
	private static String accountType(Scanner scanner) {
		String choice;
		System.out.println("Enter 1 to set savings account type");
		System.out.println("Enter 2 to set loan account type");
		System.out.println("Enter 3 to set Both Account type");
		choice = scanner.next();
		if (choice.equals("1")) {
			return "savings account";
		} else if (choice.equals("2")) {
			return "loan account";
		} else if (choice.equals("3")) {
			return "savings account,loan account";
		} else {
			System.out.println("Wrong account type...sorry try next time");
			System.exit(0);
			return null;
		}
	}

	/* -- TO FILTER THE CURRENT USER BY HIS/HER ACCOUNT NUMBER -- */
	static List<User> currentUser = null;

	public static List<User> getUserOfCurrentUser(Long accountNo) {
		currentUser = users.stream().filter(data -> (data.getAccountNo()).equals(accountNo))
				.collect(Collectors.toList());

		return currentUser;
	}

	/* -- TO FILTER THE ACCOUNT OF CURRENT USER -- */
	static List<Account> currentAccount = null;
	static List<User> curentUser = null;
	static Long curUser = null;

	public static void getUserOfCurrentAccount(Long accountNo, List<Account> account) {
		curentUser = getUserOfCurrentUser(accountNo);
		for (User curentUser : curentUser) {
			curUser = curentUser.getAccountNo();
		}
		currentAccount= account.stream().filter(data -> (data.getAccountNo()).equals(curUser))
				.collect(Collectors.toList());
	}

	/* -- TO FILTER THE ACCOUNT IF THE USER ENTERED WRONG ACCOUNT NUMBER -- */
	static List<User> ifAccountNoNotFound = null;

	public static List<User> getUserOfCurrentAccount(Long accountNo) {
		ifAccountNoNotFound = users.stream().filter(data -> !(data.getAccountNo()).equals(accountNo))
				.collect(Collectors.toList());
		return ifAccountNoNotFound;
	}

	/* TO CHECK THE ACCOUNT DETAILS OF CURRENT USER */
	public static void checkAccountDetails(Scanner scanner) {
		Long accountNo = scanner.nextLong();

		getUserOfCurrentAccount(accountNo, account);
		for (Account accountDetail : currentAccount) {
			ViewData(accountNo, scanner, accountDetail);
		}

		List<User> accountNotFound = getUserOfCurrentAccount(accountNo);
		for (User a : accountNotFound) {
			System.out.println("Your Account Number Was Not Found...");
			break;
		}
	}


	/* TO CHECK WITH USER ACCOUNT DETAILS,.... */
	public static void ViewData(Long accountNo, Scanner scanner, Account accountDetail) {
//		Account accounty = View.instanceOfAccountType(accountDetail.getAccountType());
//		System.out.println(accountDetail.getAccountType());
//		InstanceGivingClass.generateAccountType().setInstanceOfAccountType(accounty);
//
//		GenerateAccounts<Account> checkAccountTypeToDoOperation = InstanceGivingClass.generateAccountType().getInstanceOfAccountType();
//		if ((accountDetail.getAccountNo()).equals(accountNo)) {
//			System.out.println("Enter the choice\n1.Deposit\n2.withdraw\n3.balance Enquiry");
//			String choice = scanner.next();
//
//			UserAndAccountDao.toSelectOperation(choice, scanner, accountDetail, checkAccountTypeToDoOperation);
		
		
	//	Account accounty = InstanceGivingClass.account(accountDetail.getAccountType());
		System.out.println(accountDetail.getAccountType());
	//	GenerateAccount InstanceGivingClass.generateAccountType(accountDetail.getAccountType());

		GenerateAccounts checkAccountTypeToDoOperation = InstanceGivingClass.generateAccountType(accountDetail.getAccountType());
		if ((accountDetail.getAccountNo()).equals(accountNo)) {
			System.out.println("Enter the choice\n1.Deposit\n2.withdraw\n3.balance Enquiry");
			String choice = scanner.next();

			UserAndAccountDao.toSelectOperation(choice, scanner, accountDetail, checkAccountTypeToDoOperation);

			System.out.println("If You want to continue from first press 1 or press 2");
			String toContinue = scanner.next();
			if (toContinue.equals("1")) {
				LaunchMiniBankApp.ToLoop();
			} else {
				System.out.println("Thank you...");
				System.exit(0);
			}
		} else {
			System.out.println("Your acount no does not match with account type...try again later..");
		}
	}

	/*private static void toSelectOperation(String choice, Scanner scanner, Account accountDetail,
			GenerateAccounts checkAccountTypeToDoOperation) {
		// TODO Auto-generated method stub
		
	}*/

	/* -- TO SELECT OPERATION TYPE -- */
	private static void toSelectOperation(String choice, Scanner scanner, Account accountDetail,
			GenerateAccounts checkAccountTypeToDoOperation) {
		if (choice.equals("1")) {
			// To deposit...
			UserAndAccountDao.toDepositAmount(scanner, checkAccountTypeToDoOperation, accountDetail);
		} else if (choice.equals("2")) {
			// To withdraw...
			UserAndAccountDao.toWithdrawAmount(scanner, checkAccountTypeToDoOperation, accountDetail);
		} else if (choice.equals("3")) {
			// To check balance...
			System.out.println("Your current Balance is : " + accountDetail.getAccountBalance());
		} else {
			System.out.println("oops!!!.......No Such Operation...:-(");
		}
	}

	/* -- TO DEPOSIT AMOUNT -- */
	public static void toDepositAmount(Scanner scanner, GenerateAccounts checkAccountTypeToDoOperation,
			Account accountDetail) {
		System.out.println("Enter the amount you want to deposit");
		double amountToDeposit = 0.0;

		try {
			amountToDeposit = scanner.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input...Transaction Cancelled..");
			System.exit(0);
		}
		checkAccountTypeToDoOperation.deposit(amountToDeposit, accountDetail);
		writeToUser("user");
		writeToAccount("account");
		System.out.println("Thank you for using our service...");
		System.exit(0);
	}

	/* --TO WITHDRAW AMOUNT -- */
	public static void toWithdrawAmount(Scanner scanner, GenerateAccounts checkAccountTypeToDoOperation,
			Account accountDetail) {
		System.out.println("Enter the amount you want to withdraw");

		double amountToDeposit = 0.0;
		try {
			amountToDeposit = scanner.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input...Transaction Cancelled..");
			System.exit(0);
		}
		checkAccountTypeToDoOperation.withdraw(amountToDeposit, accountDetail);
		writeToUser("user");
		writeToAccount("account");
		System.out.println("Thank you for using our service...");
		System.exit(0);
	}

	public static void writeToUser(String filename) {
		WriteData.writeToUserFile(filename, users);
	}

	public static void writeToAccount(String filename) {
		WriteData.writeToAccountFile(filename, account);
	}

	public static void readFromUser(String filename) {
		users = ReadData.readUserData(filename);
	}

	public static void readFromAccount(String filename) {
		account = ReadData.readAccountData(filename);
	}
}
