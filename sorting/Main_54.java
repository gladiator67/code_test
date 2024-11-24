package com.aaa.sorting;

import java.util.Arrays;

public class Main_54 {

    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int c=0 ; c<commands.length ; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            int[] slicedArr = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(slicedArr);
            answer[c] = slicedArr[k-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        
        Arrays.stream(solution(array, commands))
        				.forEach(System.out::println);
    }
}
