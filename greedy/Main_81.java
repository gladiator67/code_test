package com.aaa.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_81 {

    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> sortedCounts = new ArrayList<>(map.values());
        sortedCounts.sort(Collections.reverseOrder());

        int numTypes = 0;
        int countSum = 0;

        for(int count : sortedCounts) {
            countSum += count;
            numTypes ++;

            if(countSum >= k)
                break;
        }

        return numTypes;
    }

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        // int k = 4;
        // int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(solution(k, tangerine));
    }
}
