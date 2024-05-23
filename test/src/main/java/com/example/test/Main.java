package com.example.test;

import java.io.*; //Imports java library to allow keyboard inputs
import java.util.*; //Imports java library to allow keyboard inputs
import java.util.regex.Pattern; // Imports the regex pattern library to allow pattern compilation

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //Brings in a new scanner called "sc" which will allow a user to input data from their keyboard

		System.out.print("Enter a math string\n"); //Prints text that asks the user for a math problem/math string
		String s = sc.nextLine(); //States that the variable "s" will be what ever is inputted by the user

		Scanner sc1 = new Scanner(s); //Sets up a new scanner called "sc1" whihc will scan s
		String regex = "((?:\\+|-)\\d+|\\d+)(?:\\s*(-|\\+))?"; // Sets up a regex pattern that will be used to find the numbers and operators in the math string
		String numberRegex = "((?:\\+|-)\\d+|\\d+)|((?:-\s*-\\d+))"; // Sets up a regex pattern that will be used to find the numbers in the math string
		final StringBuilder equation = new StringBuilder(); // Creates a string builder so that we can build the equation using the lambda operation below


		sc1.findAll(Pattern.compile(regex)).forEach(match -> { // Uses the regex pattern to find all the numbers and operators in the math string and build the equation
			equation.append(match.group(1));
			if (match.group(2) != null) {
				equation.append(" " + match.group(2));
			}
			equation.append(" ");
		});

		String equationString = equation.toString().strip(); // Converts the equation to a string and removes any leading or trailing white spaces


		final int sum[] = {0}; // Creates an array that will store the sum of the math string - this allows us to change the value of the sum in the lambda operation below
		final StringBuilder sumSteps = new StringBuilder(); // Creates a string builder so that we can build the sum steps using the lambda operation below
		Scanner sc2 = new Scanner(s); // Initiate new scanner to scan the math string
		sc2.findAll(Pattern.compile(numberRegex)).forEach(match -> { // Uses the regex pattern to find all the numbers in the math string and calculate the sum
			String numberString = match.group().strip();
			if (numberString.startsWith("--")) { // If the operation is subtraction of a negative number, it will be converted to addition
				numberString = numberString.substring(2);
			} else if (numberString.startsWith("- -")) { // If the operation is subtraction of a negative number, it will be converted to addition
				numberString = numberString.substring(3);
			} else {
				numberString = match.group();
			}
			int number = Integer.parseInt(numberString);

			if (number < 0) { // Add the sum steps to the string builder
				// sumSteps.append("\tSubtracted " + Math.abs(number) + " from " + sum[0] + " to get " + (sum[0] + number) + "\n");
				sumSteps.append("\t" + sum[0] + " - " + Math.abs(number) + " = " + (sum[0] + number) + "\n");
			} else {
				// sumSteps.append("\tAdded " + number + " to " + sum[0] + " to get " + (sum[0] + number) + "\n");
				sumSteps.append("\t" + sum[0] + " + " + number + " = " + (sum[0] + number) + "\n");
			}

			sum[0] += number; // Add the number to the sum
		});

		System.out.println("\n\n\tEquation:\t" + equationString + " = " + sum[0]); // Print the equation and the sum
		System.out.println("\nSum broken down: ");
		System.out.println(sumSteps.toString()); // Print the sum steps
	}
}
