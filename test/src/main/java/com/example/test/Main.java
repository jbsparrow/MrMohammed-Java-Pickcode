package com.example.test;

import java.util.*;
import java.util.regex.*;
import java.io.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a string to search, then press RETURN, or type 'exit' to quit: ");
		String text = sc.nextLine();

		if (text.toLowerCase().equals("exit")) {
			System.out.println("Exiting...");
			System.exit(1);
		}

		Pattern regex = Pattern.compile("([sS]\\s*[aA])", Pattern.MULTILINE);
		Matcher matcher = regex.matcher(text);
		StringBuilder matches = new StringBuilder();
		int matchCount = 0;
		while (matcher.find()) {
			matchCount++;
			matches.append("\t" + matchCount + ". " + matcher.group() + "\n");
		}

		System.out.println("\nFound " + matchCount + " matches from the string \"" + text + "\":");
		System.out.println(matches.toString().stripTrailing());
	}
}
