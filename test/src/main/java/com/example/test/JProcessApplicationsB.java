package com.example.test;

import java.io.*;
import java.util.*;


public class JProcessApplicationsB {
    private static final String Joutput_fileB = "./JPCI.txt";
    private static final String Juniversity_response_folderB = "./University Responses/";
    private static final String[] Juniversity_programsB = {
        "Computer Science (Honours)",
        "Software Engineering (Co-op)",
        "Artificial Intelligence and Machine Learning (Honours)",
        "Cybersecurity (Honours)",
        "Data Science and Analytics (Co-op)"
    };
    private static final String[] Jalternate_university_programsB = {
        "Information Technology",
        "Web Development and Design",
        "Game Design and Development",
        "Computer Networking",
        "Database Management"
    };
    private static Map<String, Integer> JstudentDataAveragesB = new Hashtable<String, Integer>();
    private static Integer JcutoffB;


    public JProcessApplicationsB(Map<String, Integer[]> JstudentDataArrayB, Integer JcutoffB) {
        JProcessApplicationsB.JcutoffB = JcutoffB;

        for (Map.Entry<String, Integer[]> JentryB : JstudentDataArrayB.entrySet()) {
            Integer JaverageB = 0;
            for (int JkB = 0; JkB < 6; JkB++) {
                JaverageB += JentryB.getValue()[JkB];
            }
            JaverageB /= 6;
            JstudentDataAveragesB.put(JentryB.getKey(), JaverageB);
        }

        // Sort the student data averages in descending order
        Map<Integer, String> JinvertedStudentDataAveragesB = new Hashtable<Integer, String>();
        for (Map.Entry<String, Integer> JentryB : JstudentDataAveragesB.entrySet()) {
            JinvertedStudentDataAveragesB.put(JentryB.getValue(), JentryB.getKey());
        }

        Integer[] JaverageGradesB = JstudentDataAveragesB.values().toArray(new Integer[0]);
        System.out.println(JaverageGradesB.toString());
        Arrays.sort(JaverageGradesB, Collections.reverseOrder());
        System.out.println(JaverageGradesB.toString());

        JstudentDataAveragesB.clear();
        Map<String, Integer> JccccaverageB = new Hashtable<String, Integer>();
        for (Integer JaverageB : JaverageGradesB) {
            System.out.println(JaverageB);
            JccccaverageB.put(JinvertedStudentDataAveragesB.get(JaverageB), JaverageB);
        }

        for (Integer JaverageB : JaverageGradesB) {
            System.out.println(JccccaverageB.get(JaverageB));
        }

        System.out.println("Student Data Averages:");

        for (Map.Entry<String, Integer> JentryB : JccccaverageB.entrySet()) {
            System.out.println(JentryB.getKey() + ": " + JentryB.getValue());
        }
    }

    public void JclearUniversityResponsesB() {
        File JfolderB = new File(Juniversity_response_folderB);
        File[] JfilesB = JfolderB.listFiles();
        if (JfilesB != null) {
            for (File JfileB : JfilesB) {
                JfileB.delete();
            }
        }
    }

    public void JwriteStudentAveragesB() throws IOException {
        FileWriter JfwB = new FileWriter(Joutput_fileB);
        PrintWriter JoutputB = new PrintWriter(JfwB);

        for (Map.Entry<String, Integer> JentryB : JstudentDataAveragesB.entrySet()) {
            JoutputB.println(JentryB.getKey() + ": " + JentryB.getValue());
            System.out.println(JentryB.getKey() + ": " + JentryB.getValue());
        }

        JoutputB.close();
        JfwB.close();
    }

    public void JwriteUniversityResponsesB() throws IOException {
        for (Map.Entry<String, Integer> JentryB : JstudentDataAveragesB.entrySet()) {
            FileWriter Jfw2B = new FileWriter(Juniversity_response_folderB + JentryB.getKey() + ".md");
            PrintWriter Joutput2B = new PrintWriter(Jfw2B);

            Random JrandomB = new Random();
            String Juniversity_programB = Juniversity_programsB[JrandomB.nextInt(Juniversity_programsB.length)];
            String Jalternate_university_programB = Jalternate_university_programsB[JrandomB.nextInt(Jalternate_university_programsB.length)];

            Joutput2B.println("# Barr University\n");
            Joutput2B.println("## Office of Admissions\n");
            Joutput2B.println("Dear " + JentryB.getKey() + ",\n\n");


            if (JentryB.getValue() >= JProcessApplicationsB.JcutoffB + 5) {
                // Accepted
                Joutput2B.println("We are pleased to inform you that you have been accepted into the <b>" + Juniversity_programB + "</b> program at Barr University. Your academic achievements, extracurricular involvement, and passion for computer science have impressed our admissions committee.\n\n");
                Joutput2B.println("We are excited to welcome you to our university community. Please review the enclosed materials for information on next steps, including important deadlines and orientation details.\n\n");
                Joutput2B.println("Congratulations and welcome to Barr University!\n\n");
                Joutput2B.println("Sincerely,\n\nJacob Barr\nDirector of Admissions\nBarr University");
            } else if (JentryB.getValue() >= JProcessApplicationsB.JcutoffB) {
                // Waitlisted
                Joutput2B.println("Thank you for your application to the <b>" + Juniversity_programB + "</b> program at Barr University. We are writing to inform you that your application has been placed on our waitlist.\n\n");
                Joutput2B.println("This year's admissions process has been highly competitive, and while we cannot offer you admission at this moment, we see great potential in your application. Should a spot become available, we will notify you immediately.\n\n");
                Joutput2B.println("We appreciate your patience and understanding.\n\n");
                Joutput2B.println("Sincerely,\n\nJacob Barr\nDirector of Admissions\nBarr University");
            } else if (JentryB.getValue() >= JProcessApplicationsB.JcutoffB - 5) {
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
    }
}
