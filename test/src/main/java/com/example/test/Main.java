package com.example.test;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Create a Scanner object to read input from the user

		System.out.println("Enter a string to search, then press RETURN, or type 'exit' to quit: "); // Prompt user to enter a string or exit
		String text = sc.nextLine(); // Read the user input and store it in the variable 'text'

		if (text.toLowerCase().equals("exit")) { // Check if the user wants to exit (case-insensitive)
			System.out.println("Exiting..."); // Inform the user that we are exiting
			System.exit(1); // Exit the program with status code 1
		}

		Pattern regex = Pattern.compile("([sS]\\s*[aA])"); // Create a regex pattern to find 's' or 'S' followed by zero or more spaces and then 'a' or 'A'
		Matcher matcher = regex.matcher(text); // Create a matcher to find the pattern in the user input
		StringBuilder matches = new StringBuilder(); // Create a StringBuilder to accumulate all the matches
		int matchCount = 0; // Initialize a counter for the number of matches found

		while (matcher.find()) { // Loop through all the matches found in the input string
			matchCount++; // Increment the match counter
			matches.append("\t" + matchCount + ". " + matcher.group() + "\n"); // Append the match to our StringBuilder
		}

		System.out.println("\nFound " + matchCount + " matches from the string \"" + text + "\":"); // Print the total number of matches found
		System.out.println(matches.toString().stripTrailing()); // Print all the matches, stripping any trailing whitespace
	}
}