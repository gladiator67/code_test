package com.aaa.greedy;

import java.util.Arrays;

public class Main_80 {

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int idx = 0;

        for(int i=people.length-1 ; i >= idx ; i--) {
            if(people[i] + people[idx] <= limit) {
                answer++;
                idx++;
            } else {
                answer++;
            }
        }

        return answer;
    }
    
    public static void main(String[] args) {
        // int[] people = {70,50,80,50};
        // int limit = 100;

        int[] people = {70,80,50};
        int limit = 100;

        System.out.println(solution(people, limit));
    }
}
