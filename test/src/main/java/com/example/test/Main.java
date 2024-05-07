package com.example.test;

public class Main {
	public static void main(String[] args) {
		Circle circle = new Circle(35.5);
		System.out.println("Initialized circle with radius 35.5:");
		System.out.println("Diameter: " + circle.getDiameter());
		System.out.println("Area: " + (double)Math.round(circle.getArea() * 1000) / 1000);
		System.out.println("Circumference: " + (double)Math.round(circle.getCircumference() * 1000) / 1000);

		circle.setRadius(40.3);
		System.out.println("\n\nSet radius to 40.3:");
		System.out.println("New Diameter: " + circle.getDiameter());
		System.out.println("New Area: " + (double)Math.round(circle.getArea() * 1000) / 1000);
		System.out.println("New Circumference: " + (double)Math.round(circle.getCircumference() * 1000) / 1000);
	}
}
