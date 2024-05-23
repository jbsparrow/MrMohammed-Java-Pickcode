package com.example.test;

import java.io.*; //Imports java library to allow keyboard inputs
import java.util.*; //Imports java library to allow keyboard inputs
import java.util.regex.Pattern; // Imports the regex pattern library to allow pattern compilation

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //Brings in a new scanner called "sc" which will allow a user to input data from their keyboard

		System.out.print("Enter a math string\n"); //Prints text that asks the user for a math problem/math string
		String s = sc.nextLine(); //States that the variable "s" will be what ever is inputted by the user

		if (
			(s.charAt(0) != '+') && (s.charAt(0) != '-')
		) s = "+" + s; //An if statement looking at the first character of s and seeing if it is equal to a + or - sign //If there is no + or - sign at the begining of the string then it will add an addition symbol to the begining

		Scanner sc1 = new Scanner(s); //Sets up a new scanner called "sc1" whihc will scan s
		// sc1.useDelimiter("\\s+\\+\\s+|\\s+\\-\\s+"); //searches the input from sc1 for an addition symbol with any combination of spaces around it as well as a subtraction symbol with any combination of spaces around it
		String regex = "((?:\\+|-)\\d+|\\d+)(?:\\s*(-|\\+))?";
        sc1.findAll(Pattern.compile(regex)).forEach(m -> {
            System.out.print(m.group(1));
            if (m.group(2) != null) {
                System.out.print(" " + m.group(2));
            }
            System.out.print(" ");
        });

		int sum = 0; //Sets the variable "sum" to equal 0

		while (sc1.hasNextInt()) { // While loop that will run so long as there is an integer in the input
			int n = sc1.nextInt(); //Sets the variable "n" to the next integer in the input
			System.out.println("Added " + n + " to " + sum + " to get " + (sum + n));
			sum += n; //Adds the next integer in the input to the sum
		}

		
	}
}
