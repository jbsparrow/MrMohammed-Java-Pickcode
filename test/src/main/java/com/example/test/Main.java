package com.example.test;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter fuel efficiency (kmpl): ");
		double kmpl = scanner.nextDouble();

		Automobile myBmw = new Automobile(kmpl);

		System.out.print("Enter how much fuel to put in the tank (litres): ");
		double litres = scanner.nextDouble();
		myBmw.fillUp(litres);

		System.out.print("Enter how far you want to drive (kilometers): ");
		double kilometers = scanner.nextDouble();
		myBmw.takeTrip(kilometers);

		System.out.println("Remaining fuel: " + ((double)Math.round(myBmw.reportFuel() * 100) / 100) + " litres. Fuel used for the trip: " + ((double)Math.round(myBmw.reportTripFuelUsage() * 100) / 100) + " litres.");
	}
}
