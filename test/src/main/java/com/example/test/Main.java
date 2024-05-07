package com.example.test;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String accountHolderName = scanner.nextLine();
		System.out.println("Enter your initial balance: ");
		double initialBalance = scanner.nextDouble();

		BankAccount account = new BankAccount(accountHolderName, initialBalance);

		while (true) {
			System.out.println("Would you like to make a deposit (1), withdraw (2), or exit (3)?");
			int choice = scanner.nextInt();
			if (choice == 3) {
				break;
			}

			if (choice != 1 && choice != 2) {
				System.out.println("Invalid choice");
				continue;
			}

			if (choice == 1) {
				System.out.println("Enter the amount you want to deposit: ");
				double depositAmount = scanner.nextDouble();
				account.deposit(depositAmount);
				System.out.println("The balance of " + account.name + "'s account is: $" + account.balance);
			} else if (choice == 2) {
				System.out.println("Enter the amount you want to withdraw: ");
				double withdrawAmount = scanner.nextDouble();
				account.withdraw(withdrawAmount);
				System.out.println("The balance of " + account.name + "'s account is: $" + account.balance);
			}
		}
	}
}
