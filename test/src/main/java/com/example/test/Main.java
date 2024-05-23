package com.example.test;

import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Encrpt/Decrypt? (E/d)");
		String choiceString = sc.nextLine();
		char choice = choiceString.trim().toLowerCase().charAt(0);

		if (choice == 'e') { // Encrypt
			System.out.print("\nEnter the string to encrypt: ");
			String input = sc.nextLine();
			String encrypted = Cryptography.encrypt(input);
			System.out.println("Encrypted string:\n\t" + encrypted);
		} else if (choice == 'd') { // Decrypt
			System.out.print("\nEnter the string to decrypt: ");
			String input = sc.nextLine();
			String decrypted = Cryptography.decrypt(input);
			System.out.println("Decrypted string:\n\t" + decrypted);
		} else { // Invalid choice
			System.out.println("Invalid choice");
		}
	}
}
