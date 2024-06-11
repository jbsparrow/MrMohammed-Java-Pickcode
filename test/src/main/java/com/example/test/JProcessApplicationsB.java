package com.example.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;


public class JProcessApplicationsB {
    // Define static variables
    private static final String JSTUDENT_STATUS_FILEB = "./OUAC.md"; // File to write acceptance statuses to - markdown format
    private static final String JUNIVERSITY_RESPONSE_FOLDERB = "./University Responses/"; // Folder to write university responses to - responses are written to markdown files
    private static final String JSORT_METHODB = "AVERAGE"; // "AVERAGE" or "ALPHABETICAL"
    private static final String JSORT_ORDERB = "DESCENDING"; // "ASCENDING" or "DESCENDING"
    private static final String[] JUNIVERSITY_PROGRAMSB = { // Programs to offer admission to
        "Computer Science (Honours)",
        "Software Engineering (Co-op)",
        "Artificial Intelligence and Machine Learning (Honours)",
        "Cybersecurity (Honours)",
        "Data Science and Analytics (Co-op)"
    };
    private static final String[] JALTERNATE_UNIVERSITY_PROGRAMSB = { // Programs to offer alternate admission to
        "Information Technology",
        "Web Development and Design",
        "Game Design and Development",
        "Computer Networking",
        "Database Management"
    };

    // Define instance variables
    private Map<String, Integer> JstudentDataAveragesB = new Hashtable<String, Integer>(); // Map to store student averages
    private String[] JstudentNamesB; // Array to store student names
    private Map<Integer, String> JinvertedStudentDataAveragesB = new Hashtable<Integer, String>(); // Map to store inverted student averages
    private Integer[] JstudentGradesB; // Array to store student grades
    private Integer JcutoffB; // Cutoff for program admission
    private Map<String, String> JstudentStatusesB = new Hashtable<String, String>(); // Map to store student admission statuses


    public JProcessApplicationsB(Map<String, Integer[]> JstudentDataB, Integer JcutoffB) {
        this.JcutoffB = JcutoffB; // Set cutoff for program admission based on input

        for (Map.Entry<String, Integer[]> JentryB : JstudentDataB.entrySet()) { // Calculate student averages
            Integer JaverageB = 0;
            for (Integer JgradeB : JentryB.getValue()) {
                JaverageB += JgradeB;
            }
            JaverageB /= 6;
            this.JstudentDataAveragesB.put(JentryB.getKey(), JaverageB); // Store student averages in map
        }

        this.JstudentNamesB = this.JstudentDataAveragesB.keySet().toArray(new String[0]); // Get student names from hashmap and store in array
        switch (JProcessApplicationsB.JSORT_ORDERB) { // Sort student names based on the selected sort order
            case "ASCENDING":
                Arrays.sort(this.JstudentNamesB);
                break;
            case "DESCENDING":
                Arrays.sort(this.JstudentNamesB, Collections.reverseOrder());
                break;
            default: // Exit if an invalid sort order is selected
                System.out.println("Invalid sort order. Please enter 'ASCENDING' or 'DESCENDING'.");
                System.exit(1);
        }

        for (String JnameB : this.JstudentNamesB) { // Invert the student averages map to allow for sorting by average
            this.JinvertedStudentDataAveragesB.put(this.JstudentDataAveragesB.get(JnameB), JnameB);
        }

        this.JstudentGradesB = this.JstudentDataAveragesB.values().toArray(new Integer[0]); // Get student averages from hashmap and store in array
        switch (JProcessApplicationsB.JSORT_ORDERB) { // Sort student averages based on the selected sort order
            case "ASCENDING":
                Arrays.sort(this.JstudentGradesB);
                break;
            case "DESCENDING":
                Arrays.sort(this.JstudentGradesB, Collections.reverseOrder());
                break;
            default: // Exit if an invalid sort order is selected
                System.out.println("Invalid sort order. Please enter 'ASCENDING' or 'DESCENDING'.");
                System.exit(1);
        }
    }

    public void JclearUniversityResponsesB() { // Clear existing university response files
        File JfolderB = new File(JProcessApplicationsB.JUNIVERSITY_RESPONSE_FOLDERB);
        if (!JfolderB.exists()) { // Create folder if it does not exist
            JfolderB.mkdir();
        }

        // Iterate through all files in the folder and delete them
        File[] JfilesB = JfolderB.listFiles();
        if (JfilesB != null) {
            for (File JfileB : JfilesB) {
                JfileB.delete();
            }
        }
    }


    public void JwriteUniversityResponsesB() throws IOException { // Write university responses to files
        for (Map.Entry<String, Integer> JentryB : this.JstudentDataAveragesB.entrySet()) { // Iterate through student averages
            FileWriter Jfw2B = new FileWriter(JProcessApplicationsB.JUNIVERSITY_RESPONSE_FOLDERB + JentryB.getKey() + ".md");
            PrintWriter Joutput2B = new PrintWriter(Jfw2B);

            // Create random object to select random program names
            Random JrandomB = new Random();
            String Juniversity_programB = JProcessApplicationsB.JUNIVERSITY_PROGRAMSB[JrandomB.nextInt(JProcessApplicationsB.JUNIVERSITY_PROGRAMSB.length)];
            String Jalternate_university_programB = JProcessApplicationsB.JALTERNATE_UNIVERSITY_PROGRAMSB[JrandomB.nextInt(JProcessApplicationsB.JALTERNATE_UNIVERSITY_PROGRAMSB.length)];

            // Write university response letter headers
            Joutput2B.println("# Barr University\n");
            Joutput2B.println("## Office of Admissions\n");
            Joutput2B.println("Dear " + JentryB.getKey() + ",\n\n");


            // Write university response letters based on student averages, cutoff, and random program selection, and add student status to hashmap
            if (JentryB.getValue() >= this.JcutoffB + 5) {
                // Accepted
                Joutput2B.println("We are pleased to inform you that you have been accepted into the <b>" + Juniversity_programB + "</b> program at Barr University. Your academic achievements, extracurricular involvement, and passion for computer science have impressed our admissions committee.\n\n");
                Joutput2B.println("We are excited to welcome you to our university community. Please review the enclosed materials for information on next steps, including important deadlines and orientation details.\n\n");
                Joutput2B.println("Congratulations and welcome to Barr University!\n\n");
                Joutput2B.println("Sincerely,\n\nJacob Barr\nDirector of Admissions\nBarr University");
                this.JstudentStatusesB.put(JentryB.getKey(), "Accepted");
            } else if (JentryB.getValue() >= this.JcutoffB) {
                // Waitlisted
                Joutput2B.println("Thank you for your application to the <b>" + Juniversity_programB + "</b> program at Barr University. We are writing to inform you that your application has been placed on our waitlist.\n\n");
                Joutput2B.println("This year's admissions process has been highly competitive, and while we cannot offer you admission at this moment, we see great potential in your application. Should a spot become available, we will notify you immediately.\n\n");
                Joutput2B.println("We appreciate your patience and understanding.\n\n");
                Joutput2B.println("Sincerely,\n\nJacob Barr\nDirector of Admissions\nBarr University");
                this.JstudentStatusesB.put(JentryB.getKey(), "Waitlisted");
            } else if (JentryB.getValue() >= this.JcutoffB - 5) {
                // Alternate Offer
                Joutput2B.println("Thank you for your application to the <b>" + Juniversity_programB + "</b> program at Barr University. While we are unable to offer you a spot in this program at this time, we are pleased to extend an alternate offer for admission to the <b>" + Jalternate_university_programB + "</b> program.\n\n");
                Joutput2B.println("We believe that your skills and interests align well with this program and that you will find it equally fulfilling. Please review the enclosed materials for more information on this opportunity.\n\n");
                Joutput2B.println("We look forward to the possibility of welcoming you to Barr University.\n\n");
                Joutput2B.println("Sincerely,\n\nJacob Barr\nDirector of Admissions\nBarr University");
                this.JstudentStatusesB.put(JentryB.getKey(), "Alternate Offer");
            } else {
                // Rejected
                Joutput2B.println("Thank you for your application to the <b>" + Juniversity_programB + "</b> program at Barr University. After careful consideration, we regret to inform you that we are unable to offer you admission at this time.\n\n");
                Joutput2B.println("The admissions process is highly competitive, and we receive many applications from talented individuals. We encourage you to continue pursuing your academic and professional goals.\n\n");
                Joutput2B.println("We wish you all the best in your future endeavors.\n\n");
                Joutput2B.println("Sincerely,\n\nJacob Barr\nDirector of Admissions\nBarr University");
                this.JstudentStatusesB.put(JentryB.getKey(), "Rejected");
            }

            Joutput2B.close();
            Jfw2B.close();
        }

        // Notify user that university response letters have been written to the selected folder
        System.out.println("University response letters have been written to the \033[3m" + JProcessApplicationsB.JUNIVERSITY_RESPONSE_FOLDERB + "\033[0m folder.");
    }

    public void JwriteStudentStatusesB() throws IOException { // Write student statuses to file
        FileWriter Jfw3B = new FileWriter(JProcessApplicationsB.JSTUDENT_STATUS_FILEB);
        PrintWriter Joutput3B = new PrintWriter(Jfw3B);

        // Write file header
        Joutput3B.println("# Student Statuses\n");

        // Write markdown table headers
        Joutput3B.println("| Student Name | Status |");
        Joutput3B.println("|--------------|--------|");
        // Sort baed on selected sort method
        switch (JProcessApplicationsB.JSORT_METHODB) {
            case "ALPHABETICAL":
                for (String JstudentB : this.JstudentNamesB) {
                    Joutput3B.println("| " + JstudentB + " | " + this.JstudentStatusesB.get(JstudentB) + " |");
                }
                break;

            case "AVERAGE":
                for (Integer JstudentGradesB : this.JstudentGradesB) {
                    Joutput3B.println("| " + this.JinvertedStudentDataAveragesB.get(JstudentGradesB) + " | " + this.JstudentStatusesB.get(this.JinvertedStudentDataAveragesB.get(JstudentGradesB)) + " |");
                }
                break;

            default:
                System.out.println("Invalid sort method. Please enter 'ALPHABETICAL' or 'AVERAGE'.");
                System.exit(1);
        }

        Joutput3B.close();
        Jfw3B.close();

        // Notify user that student statuses have been written to the selected file
        System.out.println("Student statuses have been written to \033[3m" + JProcessApplicationsB.JSTUDENT_STATUS_FILEB + "\033[0m.");
    }
}
