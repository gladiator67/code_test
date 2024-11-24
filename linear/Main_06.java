package com.aaa.linear;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_06 {

    public static int[] solution(int N, int[] stages) {

        int[] stage_challengers = new int[N+2];
        Map<Integer, Double> fails = new HashMap<>();

        for (int stage : stages) {
            stage_challengers[stage] += 1;
        }

        double total = stages.length;

        for(int i=1 ; i<=N ; i++) {
            if(stage_challengers[i] == 0) {
                fails.put(i, 0.0);
            } else {
                fails.put(i, stage_challengers[i]/total);
                total = total - stage_challengers[i];
            }
        }

        int[] answer = fails.entrySet().stream().sorted((m1, m2) 
        	-> Double.compare(m2.getValue(), m1.getValue()))
        				.mapToInt(HashMap.Entry::getKey).toArray();

        return answer;
    }

    public static void main(String[] args) {
        //int[] numbers = new int[]{2,1,3,4,1};
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        int N = 5;

        System.out.println(Arrays.toString(solution(N, stages)));
    }
}
