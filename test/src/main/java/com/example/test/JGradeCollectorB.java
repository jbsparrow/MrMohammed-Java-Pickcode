package com.example.test;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class JGradeCollectorB {
    public Integer JstudentsB;
    private Integer JcutoffB;
    private Map<String, Integer[]> JstudentDataArrayB = new Hashtable<String, Integer[]>();

    public JGradeCollectorB() {
        Scanner JinputB = new Scanner(System.in);
        System.out.print("How many students would you like to input? ");
        if (!JinputB.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.exit(1);
        }
        this.JstudentsB = JinputB.nextInt();
        if (this.JstudentsB < 1) {
            System.out.println("Invalid number of students. Please enter a number greater than 0.");
            System.exit(1);
        }

        System.out.print("What is the cutoff for the program being applied to? (50-100): ");
        if (!JinputB.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.exit(1);
        }
        this.JcutoffB = JinputB.nextInt();
        if (this.JcutoffB < 50 || this.JcutoffB > 100) {
            System.out.println("Invalid cutoff. Please enter a number between 50 and 100.");
            System.exit(1);
        }


        for (int JiB = 0; JiB < this.JstudentsB; JiB++) {
            System.out.print("Enter student name: ");
            while (JinputB.hasNextInt()) {
                JinputB.nextLine();
            }
            String JnameB = JinputB.next();

            System.out.print("Enter student's top six grades (separated by spaces): ");
            Integer JgradesB[] = new Integer[6];
            Integer JtempGradeB;
            for (int JjB = 0; JjB < 6; JjB++) {
                JtempGradeB = JinputB.nextInt();
                if (JtempGradeB < 0 || JtempGradeB > 100) {
                    System.out.println("Invalid grade. Please enter a grade between 50 and 100.");
                    System.exit(1);
                } else if(JtempGradeB < 50) {
                    System.out.println("Student " + JnameB + " has failed a course.");
                    System.exit(1);
                } else {
                    JgradesB[JjB] = JtempGradeB;
                }
            }

            if (JgradesB.length != 6) {
                System.out.println("Invalid number of grades for student " + JnameB + ". Please enter six grades.");
                System.exit(1);
            }

            this.JstudentDataArrayB.put(JnameB, JgradesB);
        }

        JinputB.close();
    }

    public Map<String, Integer[]> JgetStudentDataArrayB() {
        return this.JstudentDataArrayB;
    }

    public Integer JgetCutoffB() {
        return this.JcutoffB;
    }
}
