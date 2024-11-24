package com.aaa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_56 {

    public static int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();

        s = s.substring(2);
        s = s.substring(0, s.length()-2).replace("},{", "-");

        String str[] = s.split("-");

        Arrays.sort(str, (str1, str2) 
        		->Integer.compare(str1.length(), str2.length()));

        for(String x : str) {
            String[] tmp = x.split(",");

            for(int i=0 ; i<tmp.length ; i++) {
                int n = Integer.parseInt(tmp[i]);
                if(!answer.contains(n))
                    answer.add(n);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) {
        //String str = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String str = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        
        Arrays.stream(solution(str)).forEach(System.out::print);
    }
}
