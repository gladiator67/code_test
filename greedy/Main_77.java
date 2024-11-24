package com.aaa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main_77 {

    private static int[] solution(int amount) {
        int[] denomination = {100, 50, 10, 1};
        List<Integer> change = new ArrayList<>();

        for(int coin : denomination) {
            while(amount >= coin) {
                change.add(coin);
                amount -= coin;
            }
        }

        return change.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) {
        
        System.out.println(Arrays.stream(solution(123))
        .boxed().collect(Collectors.toList()));
    }
}
