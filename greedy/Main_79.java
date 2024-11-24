package com.aaa.greedy;

import java.util.Arrays;

public class Main_79 {

    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;

        for(int amount : d) {
            budget -= amount;

            if(budget >= 0) {
                answer ++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // int[] d = {1,3,2,5,4};
        // int budget = 9;

        int[] d = {2,2,3,3};
        int budget = 10;

        System.out.println(solution(d, budget));
    }
}
