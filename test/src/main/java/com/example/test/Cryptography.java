package com.example.test;

public class Cryptography {
    public static String encrypt(String input) {
        input = input.replaceAll("(?i)m", "ssad");
        input = input.replaceAll("(?i)b", "dug>?/");
        input = input.replaceAll("(?i)g", "jeb..w");
        input = input.replaceAll("(?i)v", "ag',r");

        return input;
    }
    
    public static String decrypt(String input) {        
        input = input.replaceAll("ag',r", "v");
        input = input.replaceAll("jeb\\.\\.w", "g");
        input = input.replaceAll("dug>\\?/", "b");
        input = input.replaceAll("ssad", "m");

        return input;
    }
}