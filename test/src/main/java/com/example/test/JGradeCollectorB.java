package com.example.test;

import java.io.*;
import java.util.*;

public class JGradeCollectorB {
    private static final String Joutput_fileB = "./JPCI.txt";
    public static Integer JstudentsB;

    public JGradeCollectorB() throws IOException {
        FileWriter JfwB = new FileWriter(Joutput_fileB);
        PrintWriter JoutputB = new PrintWriter(JfwB);

        Scanner JinputB = new Scanner(System.in);
        System.out.print("How many students would you like to input? ");
        if (!JinputB.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.exit(1);
        }
        JstudentsB = JinputB.nextInt();
        if (JstudentsB < 1) {
            System.out.println("Invalid number of students. Please enter a number greater than 0.");
            System.exit(1);
        }

        JstudentDataArrayB JstudentDataArrayB = new JstudentDataArrayB(JstudentsB);

        for (int JiB = 0; JiB < JstudentsB; JiB++) {
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
                    System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
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
            // Sort the grades in descending order
            Arrays.sort(JgradesB, Collections.reverseOrder());
            System.out.println("Student " + JnameB + " has the following grades: " + Arrays.toString(JgradesB));
        }



        JoutputB.close();
        JfwB.close();
        JinputB.close();
    }
}
