package com.aaa.linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_04 {

    public static int[] solution(int[] answers) {

        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for(int i=0 ; i<answers.length ; i++) {
            if(answers[i] == pattern1[i%5]) scores[0]++;  // 패턴을 반복하기위해 % 연산자를 사용
            if(answers[i] == pattern2[i%8]) scores[1]++;  // 패턴을 반복하기위해 % 연산자를 사용
            if(answers[i] == pattern3[i%10]) scores[2]++; // 패턴을 반복하기위해 % 연산자를 사용
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        List<Integer> giveupGuys = new ArrayList<>();
        for(int i=0; i<scores.length; i++) {
            if(scores[i] == maxScore) {
                giveupGuys.add(i+1);
            }
        }
        
        return giveupGuys.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        //int[] numbers = new int[]{2,1,3,4,1};
        int[] numbers = new int[]{1,3,2,4,2};

        System.out.println(Arrays.toString(solution(numbers)));
    }
}
