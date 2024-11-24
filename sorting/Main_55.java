package com.aaa.sorting;

import java.util.ArrayList;
import java.util.List;

public class Main_55 {

    public static String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        
        for(int n : numbers) {
            list.add(String.valueOf(n));
        }

        list.sort((s1, s2) -> {
            int a = Integer.parseInt(s1+s2);
            int b = Integer.parseInt(s2+s1);
            return Integer.compare(b, a);
        });

        StringBuilder sb = new StringBuilder();

        for(String str : list) {
            sb.append(str);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        // int[] numbers = {6, 10, 2};
        int[] numbers = {3, 30, 34, 5, 9};
        
        System.out.println(solution(numbers));
    }
}
