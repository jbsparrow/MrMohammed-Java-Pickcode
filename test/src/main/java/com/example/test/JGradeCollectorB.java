package com.example.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class JGradeCollectorB {
    // Define static variables
    public static final String JSTUDENT_DATA_FILEB = "JPCI.txt"; // File to write student data to

    // Define instance variables
    public Integer JstudentsB;
    private Integer JcutoffB; // Cutoff for the program being applied to
    private Map<String, Integer[]> JstudentDataB = new Hashtable<String, Integer[]>(); // Student data array
    private Scanner JinputB = new Scanner(System.in);

    public JGradeCollectorB() {
        System.out.print("How many students would you like to input? ");
        if (this.JinputB.hasNextInt() == false && this.JinputB.hasNext() == true) { // Check if input is an integer and exit if not
            System.out.println("Invalid input. Please enter a number.");
            System.exit(1);
        }
        this.JstudentsB = this.JinputB.nextInt(); // Set number of students
        if (this.JstudentsB < 1) { // Check if number of students is less than 1 and exit if so
            System.out.println("Invalid number of students. Please enter a number greater than 0.");
            System.exit(1);
        }
        System.out.println();

        for (int JiB = 0; JiB < this.JstudentsB; JiB++) { // Iterate through each student
            System.out.print("Enter student name: ");
            while (this.JinputB.hasNextInt()) { // Check if input is a number and skip if so - this prevents the program from taking an overflow of input from someone entering more than six grades
                this.JinputB.nextLine();
            }
            String JnameB = this.JinputB.next(); // Set student name

            System.out.print("Enter student's top six grades (separated by spaces): ");
            Integer JgradesB[] = new Integer[6]; // Create array to store student grades
            Integer JtempGradeB; // Temporary variable to store grade input so it can be validated.
            for (int JjB = 0; JjB < 6; JjB++) { // Iterate through each grade
                JtempGradeB = this.JinputB.nextInt(); // Set temporary grade
                if (JtempGradeB < 0 || JtempGradeB > 100) { // Check if the grade is between 0 and 100 and exit if not
                    System.out.println("Invalid grade. Please enter a grade between 50 and 100.");
                    System.exit(1);
                } else if(JtempGradeB < 50) { // Check if the grade is below the cutoff and exit if so
                    System.out.println("Student " + JnameB + " has failed a course.");
                    System.exit(1);
                } else { // Add grade to array if it is valid
                    JgradesB[JjB] = JtempGradeB;
                }
            }

            if (JgradesB.length != 6) { // Check if the number of grades is not equal to six and exit if not
                System.out.println("Invalid number of grades for student " + JnameB + ". Please enter six grades.");
                System.exit(1);
            }

            this.JstudentDataB.put(JnameB, JgradesB); // Add student data to array
        }

        // JinputB.close();
    }

    public void JcollectCutoffB() {
        // Scanner JinputB = new Scanner(System.in);
        // JinputB.reset();
        // JinputB.next();
        System.out.print("\nWhat is the cutoff for the program being applied to? (50-100): ");

        if (this.JinputB.hasNextInt() == false && this.JinputB.hasNext() == true) { // Check if input is an integer and exit if not
            System.out.println("Invalid input. Please enter a number.");
            System.exit(1);
        }

        this.JcutoffB = this.JinputB.nextInt(); // Set cutoff for the program being applied to
        if (this.JcutoffB < 50 || this.JcutoffB > 100) { // Check if cutoff is between 50 and 100 and exit if not
            System.out.println("Invalid cutoff. Please enter a number between 50 and 100.");
            System.exit(1);
        }
        System.out.println();

        this.JinputB.close(); // Close scanner
    }

    public Map<String, Integer[]> JgetStudentDataB() {
        return this.JstudentDataB; // Return student data array
    }

    public Integer JgetCutoffB() {
        return this.JcutoffB; // Return cutoff for the program being applied to
    }

    public void JwriteStudentDataB() throws IOException { // Write student data to file
        FileWriter JfileWriterB = new FileWriter(JSTUDENT_DATA_FILEB); // Create new file writer
        PrintWriter JprintWriterB = new PrintWriter(JfileWriterB); // Create new print writer

        for (Map.Entry<String, Integer[]> JentryB : this.JstudentDataB.entrySet()) { // Iterate through each student
            JprintWriterB.print(JentryB.getKey() + ": "); // Write student name to file
            for (Integer JgradeB : JentryB.getValue()) { // Iterate through each grade
                JprintWriterB.print(JgradeB + " "); // Write grade to file
            }
            JprintWriterB.println(); // Move to next line
        }

        JprintWriterB.close(); // Close print writer
        JfileWriterB.close(); // Close file writer
    }
}
