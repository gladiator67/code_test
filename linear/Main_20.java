package com.aaa.linear;

import java.util.HashMap;
import java.util.Map;

public class Main_20 {

    public static int solution(String[] want, 
    							int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i=0 ; i< want.length ; i++) {
            wantMap.put(want[i], number[i]);
        }

        for(int i=0 ; i<discount.length - 10 + 1 ; i++) {
            Map<String, Integer> discount10d = new HashMap<>();

            for(int j=i ; j<i+10 ; j++) {
                if(wantMap.containsKey(discount[j])) {
                    discount10d.put(discount[j], 
                    		discount10d.getOrDefault(discount[j], 0) + 1);
                }
            }

            if(discount10d.equals(wantMap)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", 
        	"rice", "apple", "pork", "banana", "pork", "rice", "pot", 
        	"banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));
    }
}
