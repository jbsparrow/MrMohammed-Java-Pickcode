package com.example.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class JFileReaderB {
    String JfilenameB;

    public JFileReaderB(String JfilenameB) throws IOException {
        this.JfilenameB = JfilenameB;
    }

    private String JreadFileB() throws IOException {
        BufferedReader JreaderB = new BufferedReader(new FileReader(this.JfilenameB));
        StringBuilder JstringBuilderB = new StringBuilder();
        String JlineB;
        while ((JlineB = JreaderB.readLine()) != null) {
            JstringBuilderB.append(JlineB);
            JstringBuilderB.append("\n");
        }
        JreaderB.close();
        return JstringBuilderB.toString();
    }

    private Map<String, Integer[]> JmakeHashmapB(String JfileDataB) {
        Map<String, Integer[]> JstudentDataB = new Hashtable<String, Integer[]>();
        String[] JlinesB = JfileDataB.split("\n");
        for (String JlineB : JlinesB) {
            String[] JdataB = JlineB.split(":");
            String JnameB = JdataB[0];
            Scanner JinputB = new Scanner(JdataB[1]);
            Integer[] JgradesB = new Integer[6];
            // Use scanner to read in grades
            for (int JiB = 0; JiB < 6; JiB++) {
                JgradesB[JiB] = JinputB.nextInt();
            }

            JinputB.close();
            JstudentDataB.put(JnameB, JgradesB);
        }
        return JstudentDataB;
    }

    public Map<String, Integer[]> JgetStudentDataB() throws IOException {
        String JfileDataB = JreadFileB();
        return JmakeHashmapB(JfileDataB);
    }
}
