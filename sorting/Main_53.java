package com.aaa.sorting;

import java.util.Arrays;
import java.util.Collections;

public class Main_53 {

    private static long solution(long l) {
        String[] digits = String.valueOf(l).split("");
        Arrays.sort(digits, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String digit: digits) {
            sb.append(digit);
        }
        
        return Long.parseLong(sb.toString());
    }
    
    public static void main(String[] args) {
        long l = 118372;
        // String s = "algorithm";
        
        System.out.println(solution(l));
    }
}
