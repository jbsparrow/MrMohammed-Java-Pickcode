package com.example.test;

import java.util.*;

public class JProcessApplicationsB {
    private static Map<String, Integer> JstudentDataAveragesB = new Hashtable<String, Integer>();

    public JProcessApplicationsB(Map<String, Integer[]> JstudentDataArrayB, Integer cutoff) {
        for (Map.Entry<String, Integer[]> JentryB : JstudentDataArrayB.entrySet()) {
            System.out.print(JentryB.getKey() + ": ");
            for (int JkB = 0; JkB < 6; JkB++) {
                System.out.print(JentryB.getValue()[JkB] + " ");
            }
            System.out.println();
        }

        for (Map.Entry<String, Integer[]> JentryB : JstudentDataArrayB.entrySet()) {
            Integer JaverageB = 0;
            for (int JkB = 0; JkB < 6; JkB++) {
                JaverageB += JentryB.getValue()[JkB];
            }
            JaverageB /= 6;
            JstudentDataAveragesB.put(JentryB.getKey(), JaverageB);
        }

        for (Map.Entry<String, Integer> JentryB : JstudentDataAveragesB.entrySet()) {
            System.out.println(JentryB.getKey() + ": " + JentryB.getValue());
        }
    }
}
