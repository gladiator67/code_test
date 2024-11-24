package com.aaa.linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_03 {

    public static int[] solution(int[] numbers) {
        List<Integer> sum = new ArrayList<>();

        for(int i=0 ; i<numbers.length-1 ; i++) {
            for(int j=i+1 ; j<numbers.length ; j++) {
                sum.add(numbers[i]+numbers[j]);
            }
        }
        
        return sum.stream().distinct().sorted().mapToInt(Integer::intValue).toArray() ;
    }    

    public static void main(String[] args) {
        //int[] numbers = new int[]{2,1,3,4,1};
        int[] numbers = new int[]{5,0,2,7};

        System.out.println(Arrays.toString(solution(numbers)));
    }
}
