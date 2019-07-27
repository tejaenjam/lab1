package com.cap.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cap.beans.BankBean;
import com.cap.beans.TransBean;
import com.cap.dao.AccountNotFoundException;
import com.cap.dao.Balance;
import com.cap.dao.PasswordNotFoundException;
import com.cap.service.BankService;

public class BankUI {
	BankService b = new BankService();
	long bacc;
	String bnum1, bname, bpass1, bdob1;
	int i = 0;
	Scanner sc = new Scanner(System.in);

	void stmt() {
		System.out.println("WELCOME TO XYZ BANK SERVICE JDBC\n");
		System.out.println("************************************************* \n");
		System.out.println("enter options \n");
		System.out.println("1.create ");
		System.out.println("2.balance ");
		System.out.println("3.deposit ");
		System.out.println("4.withdrawl ");
		System.out.println("5.fund Transfer ");
		System.out.println("6.print transacion  ");
		System.out.println("7.exit  ");
	}

	void choose() throws ClassNotFoundException, SQLException {

		while (1 != 0) {
			stmt();
			int n = sc.nextInt();

			switch (n) {

			case 1:
				System.out.println("enter your name \n");
				bname = sc.next();
				boolean bname1 = b.namecheck(bname);
				while (1 != 0) {
					if (bname1) {
						System.out.println("name is corrrect");
						break;
					} else {
						System.out.println("enter correct name");
						bname = sc.next();
						bname1 = b.namecheck(bname);
					}
				}

				System.out.println("enter 10 digit  mobile number \n");
				String bnum1 = sc.next();
				boolean bnum2 = b.numbercheck(bnum1);
				while (1 != 0) {
					if (bnum2) {
						System.out.println("number is correct");
						break;
					} else {
						System.out.println("enter correct number");
						bnum1 = sc.next();
						bnum2 = b.numbercheck(bnum1);

					}
				}

				// check dob
				System.out.println("enter date of birth DD:MM:YYYY \n");
				bdob1 = sc.next();
				boolean bdob = b.dobcheck(bdob1);
				while (1 != 0) {
					if (bdob) {
						System.out.println("date of birth is valid");
						break;
					} else {
						System.out.println("enter correct date of birth");
						bdob1 = sc.next();
						bdob = b.dobcheck(bdob1);
					}
				}
				// check passsword
				System.out.println("enter password and must be 8 digits \n");
				bpass1 = sc.next();
				boolean bpass = b.checkpassword(bpass1);
				while (1 != 0) {
					if (bpass) {
						System.out.println("password is valid");
						break;
					} else {
						System.out.println("enter correct password");
						bpass1 = sc.next();
						bpass = b.checkpassword(bpass1);
					}
				}

				System.out.println("enter account type \n");
				String actype = sc.next();

				System.out.println(" Bank Branch \n ");
				String location = sc.next();

				System.out.println("minimum balance is  : 1000  \n");
				int bbal = 1000;
				long bnum = Long.parseLong(bnum1);
				bacc = bnum + 123456;

				BankBean bean = new BankBean(bname, bnum1, bdob1, bpass1, bbal, bacc, location, actype);
				Long accNum = b.createAccount(bean);
				if (accNum > 0) {
					System.out.println("Account Created with !" + accNum);

				}
				break;

			case 2:
				System.out.println("enter your account number \n");
				long account1 = sc.nextLong();
				System.out.println("enter password \n");
				String password1 = sc.next();
				try {
					int a1 = b.showbalance(account1, password1);
					System.out.println("Available Balance  : " + a1);
				} catch (AccountNotFoundException exception) {
					System.out.println(exception.getMessage());
				} catch (PasswordNotFoundException pa) {
					System.out.println(pa.getMessage());
				}
				break;

			case 3:
				System.out.println("enter your account number \n");
				long account2 = sc.nextLong();

				while (1 != 0) { // account
					boolean val21 = b.validation(account2);
					if (val21) {
						System.out.println("account number is correct \n");
						break;
					} else {
						System.out.println("enter valid account number \n");

						account2 = sc.nextLong();
					}
				}
				System.out.println("enter password \n");
				String password2 = sc.next();

				System.out.println("enter deposit amount \n");
				int dep1 = sc.nextInt();
				int a11 = b.deposit(account2, password2, dep1);
				System.out.println("balance after deposit \n");
				System.out.println(a11);
				break;

			case 4:
				System.out.println("enter your account number \n");
				long account3 = sc.nextLong();

				while (1 != 0) { // account
					boolean val21 = b.validation(account3);
					if (val21) {
						System.out.println("account number is correct \n");
						break;
					} else {
						System.out.println("enter valid account number \n");

						account3 = sc.nextLong();
					}
				}
				System.out.println("enter password \n");
				String password3 = sc.next();
				System.out.println("enter withdrawl amount \n");
				int dep3 = sc.nextInt();
				int a111 = b.withdrawl(account3, password3, dep3);
				System.out.println("balance after withdrawl \n");
				System.out.println(a111);
				break;

			case 5:
				System.out.println("enter account 1 to send funds \n");
				long account31 = sc.nextLong();

				System.out.println("enter password \n");
				String password31 = sc.next();

				System.out.println("enter account 2 to receive funds \n");
				long account32 = sc.nextLong();

				System.out.println("enter fund amount \n");
				int k1 = sc.nextInt();

				try {
					String ba12 = b.fund(account31, account32, password31, k1);
					System.out.println(ba12);
				} catch (AccountNotFoundException ae) {
					System.out.println(ae.getMessage());
				} catch (PasswordNotFoundException pa) {
					System.out.println(pa.getMessage());
				} catch (Balance de) {
					System.out.println("invalid account number \n");
				}
				break;

			case 6:
				System.out.println("print  transaction \n");
				System.out.println("enter account number \n");
				long account33 = sc.nextLong();

				while (1 != 0) { // account
					boolean val21 = b.validation(account33);
					if (val21) {
						System.out.println("account number is correct \n");
						break;
					} else {
						System.out.println("enter valid account number \n");

						account31 = sc.nextLong();
					}
				}
				System.out.println("enter password \n");
				String password34 = sc.next();
				List listui = b.transactionui(account33);
				System.out.println(listui);
				break;

			case 7:
				System.out.println("Thank you");
				break;

			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		BankUI a1 = new BankUI();
		a1.choose();
	}
}
