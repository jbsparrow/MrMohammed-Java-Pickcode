package com.example.test;

import java.io.*;
import java.util.*;


public class JProcessApplicationsB {
    // Define static variables
    private static final String JOUTPUT_FILEB = "./JPCI.txt";
    private static final String JUNIVERSITY_RESPONSE_FOLDERB = "./University Responses/";
    private static final String JSORT_METHODB = "ALPHABETICAL"; // "AVERAGE" or "ALPHABETICAL"
    private static final String JSORT_ORDERB = "ASCENDING"; // "ASCENDING" or "DESCENDING"
    private static final String[] JUNIVERSITY_PROGRAMSB = {
        "Computer Science (Honours)",
        "Software Engineering (Co-op)",
        "Artificial Intelligence and Machine Learning (Honours)",
        "Cybersecurity (Honours)",
        "Data Science and Analytics (Co-op)"
    };
    private static final String[] JALTERNATE_UNIVERSITY_PROGRAMSB = {
        "Information Technology",
        "Web Development and Design",
        "Game Design and Development",
        "Computer Networking",
        "Database Management"
    };

    // Define instance variables
    private Map<String, Integer> JstudentDataAveragesB = new Hashtable<String, Integer>();
    private String[] JstudentNamesB;
    private Map<Integer, String> JinvertedStudentDataAveragesB = new Hashtable<Integer, String>();
    private Integer[] JstudentGradesB;
    private Integer JcutoffB;


    public JProcessApplicationsB(Map<String, Integer[]> JstudentDataArrayB, Integer JcutoffB) {
        this.JcutoffB = JcutoffB;

        for (Map.Entry<String, Integer[]> JentryB : JstudentDataArrayB.entrySet()) {
            Integer JaverageB = 0;
            for (int JkB = 0; JkB < 6; JkB++) {
                JaverageB += JentryB.getValue()[JkB];
            }
            JaverageB /= 6;
            this.JstudentDataAveragesB.put(JentryB.getKey(), JaverageB);
        }

        this.JstudentNamesB = this.JstudentDataAveragesB.keySet().toArray(new String[0]);
        switch (JProcessApplicationsB.JSORT_ORDERB) {
            case "ASCENDING":
                Arrays.sort(this.JstudentNamesB);
                break;
            case "DESCENDING":
                Arrays.sort(this.JstudentNamesB, Collections.reverseOrder());
                break;
            default:
                System.out.println("Invalid sort order. Please enter 'ASCENDING' or 'DESCENDING'.");
                System.exit(1);
        }

        for (String JnameB : this.JstudentNamesB) {
            this.JinvertedStudentDataAveragesB.put(this.JstudentDataAveragesB.get(JnameB), JnameB);
        }

        this.JstudentGradesB = this.JstudentDataAveragesB.values().toArray(new Integer[0]);
        switch (JProcessApplicationsB.JSORT_ORDERB) {
            case "ASCENDING":
                Arrays.sort(this.JstudentGradesB);
                break;
            case "DESCENDING":
                Arrays.sort(this.JstudentGradesB, Collections.reverseOrder());
                break;
            default:
                System.out.println("Invalid sort order. Please enter 'ASCENDING' or 'DESCENDING'.");
                System.exit(1);
        }
    }

    public void JclearUniversityResponsesB() {
        File JfolderB = new File(JProcessApplicationsB.JUNIVERSITY_RESPONSE_FOLDERB);
        if (!JfolderB.exists()) {
            JfolderB.mkdir();
        }
        File[] JfilesB = JfolderB.listFiles();
        if (JfilesB != null) {
            for (File JfileB : JfilesB) {
                JfileB.delete();
            }
        }
    }

    public void JwriteStudentAveragesB() throws IOException {
        FileWriter JfwB = new FileWriter(JProcessApplicationsB.JOUTPUT_FILEB);
        PrintWriter JoutputB = new PrintWriter(JfwB);

        switch (JProcessApplicationsB.JSORT_METHODB) {
            case "AVERAGE":
                for (Integer JgradeB : this.JstudentGradesB) {
                    JoutputB.println(this.JinvertedStudentDataAveragesB.get(JgradeB) + ": " + JgradeB);
                }
                break;

            case "ALPHABETICAL":
                for (String JnameB : this.JstudentNamesB) {
                    JoutputB.println(JnameB + ": " + this.JstudentDataAveragesB.get(JnameB));
                }
                break;

            default:
                System.out.println("Invalid sort method. Please enter 'AVERAGE' or 'ALPHABETICAL'.");
                System.exit(1);
        }

        JoutputB.close();
        JfwB.close();

        System.out.println("Student averages have been written to \033[3m" + JProcessApplicationsB.JOUTPUT_FILEB + "\033[0m.");
    }

    public void JwriteUniversityResponsesB() throws IOException {
        for (Map.Entry<String, Integer> JentryB : this.JstudentDataAveragesB.entrySet()) {
            FileWriter Jfw2B = new FileWriter(JProcessApplicationsB.JUNIVERSITY_RESPONSE_FOLDERB + JentryB.getKey() + ".md");
            PrintWriter Joutput2B = new PrintWriter(Jfw2B);

            Random JrandomB = new Random();
            String Juniversity_programB = JProcessApplicationsB.JUNIVERSITY_PROGRAMSB[JrandomB.nextInt(JProcessApplicationsB.JUNIVERSITY_PROGRAMSB.length)];
            String Jalternate_university_programB = JProcessApplicationsB.JALTERNATE_UNIVERSITY_PROGRAMSB[JrandomB.nextInt(JProcessApplicationsB.JALTERNATE_UNIVERSITY_PROGRAMSB.length)];

            Joutput2B.println("# Barr University\n");
            Joutput2B.println("## Office of Admissions\n");
            Joutput2B.println("Dear " + JentryB.getKey() + ",\n\n");


            if (JentryB.getValue() >= this.JcutoffB + 5) {
                // Accepted
                Joutput2B.println("We are pleased to inform you that you have been accepted into the <b>" + Juniversity_programB + "</b> program at Barr University. Your academic achievements, extracurricular involvement, and passion for computer science have impressed our admissions committee.\n\n");
                Joutput2B.println("We are excited to welcome you to our university community. Please review the enclosed materials for information on next steps, including important deadlines and orientation details.\n\n");
                Joutput2B.println("Congratulations and welcome to Barr University!\n\n");
                Joutput2B.println("Sincerely,\n\nJacob Barr\nDirector of Admissions\nBarr University");
            } else if (JentryB.getValue() >= this.JcutoffB) {
                // Waitlisted
                Joutput2B.println("Thank you for your application to the <b>" + Juniversity_programB + "</b> program at Barr University. We are writing to inform you that your application has been placed on our waitlist.\n\n");
                Joutput2B.println("This year's admissions process has been highly competitive, and while we cannot offer you admission at this moment, we see great potential in your application. Should a spot become available, we will notify you immediately.\n\n");
                Joutput2B.println("We appreciate your patience and understanding.\n\n");
                Joutput2B.println("Sincerely,\n\nJacob Barr\nDirector of Admissions\nBarr University");
            } else if (JentryB.getValue() >= this.JcutoffB - 5) {
                // Alternate Offer
                Joutput2B.println("Thank you for your application to the <b>" + Juniversity_programB + "</b> program at Barr University. While we are unable to offer you a spot in this program at this time, we are pleased to extend an alternate offer for admission to the <b>" + Jalternate_university_programB + "</b> program.\n\n");
                Joutput2B.println("We believe that your skills and interests align well with this program and that you will find it equally fulfilling. Please review the enclosed materials for more information on this opportunity.\n\n");
                Joutput2B.println("We look forward to the possibility of welcoming you to Barr University.\n\n");
                Joutput2B.println("Sincerely,\n\nJacob Barr\nDirector of Admissions\nBarr University");
            } else {
                // Rejected
                Joutput2B.println("Thank you for your application to the <b>" + Juniversity_programB + "</b> program at Barr University. After careful consideration, we regret to inform you that we are unable to offer you admission at this time.\n\n");
                Joutput2B.println("The admissions process is highly competitive, and we receive many applications from talented individuals. We encourage you to continue pursuing your academic and professional goals.\n\n");
                Joutput2B.println("We wish you all the best in your future endeavors.\n\n");
                Joutput2B.println("Sincerely,\n\nJacob Barr\nDirector of Admissions\nBarr University");
            }

            Joutput2B.close();
            Jfw2B.close();
        }

        System.out.println("University response letters have been written to the \033[3m" + JProcessApplicationsB.JUNIVERSITY_RESPONSE_FOLDERB + "\033[0m folder.");
    }
}
