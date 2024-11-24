package com.aaa.sorting;

public class Main_50 {

    private static String solution(String s) {
        int[] counts = new int[26];

        for(char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        StringBuilder str = new StringBuilder();

        for(int i=0 ; i<counts.length ; i++) {
            for(int j=0 ; j<counts[i] ; j++) {
                str.append((char)(i + 'a'));
            }
        }
        
        return str.toString();
    }
    
    public static void main(String[] args) {
        String s = "hello";
        // String s = "algorithm";
        
        System.out.println(solution(s));
    }
}
