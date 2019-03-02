package com.cg.mra.ui;

import java.util.Scanner;

import javax.security.auth.login.AccountException;

import com.cg.mra.beans.Account;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {
	static Scanner sc;

	public static void main(String[] args) throws AccountException {

		AccountService service = new AccountServiceImpl();
		sc = new Scanner(System.in);
		int ch = 0;
		do {
			// This Is To Display The Menu
			System.out.println("*****************Mobile Application****************");
			System.out.println("\n1. Account Balance Enquiry ");
			System.out.println("2. Recharge Account ");
			System.out.println("3. Exit ");
			System.out.println("***************************************************");
			System.out.println("");
			System.out.println("Enter Your Choice : ");
			ch = sc.nextInt();
			switch (ch) {

			case 1:
				// to display account balance
				System.out.println("Enter Mobile No : ");
				String mobileNo = sc.next();
				if (service.validatemobNo(mobileNo)) {
					Account acc = service.getAccountDetails(mobileNo);
					if (acc == null) {
						System.out.println("Given Account Id Does Not Exits ");
						System.out.println("");
					} else {
						System.out.println("Your Current Balance is Rs. " + acc.getAccountBalance());
						System.out.println("");
					}
				}

				else {
					System.out.println("Enter 10 digit Mobile Number");
					System.out.println("");
				}

				break;

			case 2:
				// to recharges account
				System.out.println("Enter MobileNo : ");
				String mobNo = sc.next();
				System.out.println("Enter Recharge Amount : ");
				double amount = sc.nextDouble();
				if (service.validatemobNo(mobNo)) {
					if (amount == 0) {
						System.out.println("Recharge amount cannot be zero");
						System.out.println("");
					} else if (service.validateReAmount(amount)) {
						double newbalance = service.rechargeAccount(mobNo, amount);
						if (newbalance == 0) {
							System.out.println("Cannot Recharge Account as Given Mobile No Does Not Exists ");
							System.out.println("");
						} else {
							Account acc1 = service.getAccountDetails(mobNo);
							System.out.println("Your Account Recharged Successfully");
							System.out.println(
									"Hello " + acc1.getCustomerName() + ",Available Balance is " + newbalance + ".");
							System.out.println("");
						}
					} else
						System.out.println("enter valid Recharge Amount");
					System.out.println("");

				} else
					System.out.println("Enter 10 digit Mobile Number");
				System.out.println("");

				break;

			}

		} while (ch != 3);

	}

}
