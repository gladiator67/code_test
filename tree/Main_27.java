package com.aaa.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main_27 {

    public static int[] solution(String[] enroll, String[] referral, 
    									String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> memberIndexMap = new HashMap<>();

        for(int i=0 ; i<enroll.length ; i++) {
            parentMap.put(enroll[i], referral[i]);
            memberIndexMap.put(enroll[i], i);
        }

        for(int i=0 ; i<seller.length ; i++) {
            String curName = seller[i];
            int profit = amount[i]*100;

            while(!curName.equals("-")) {
                int profit4Parent = profit/10;
                int curProfit = profit - profit4Parent;

                answer[memberIndexMap.get(curName)] += curProfit;

                curName = parentMap.get(curName);
                profit /= 10;

                if(profit < 1) {
                    break;
                }
            }
        }

        return answer;
    }

        public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", 
        									"emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", 
        									"mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.stream(solution(enroll, referral, seller, amount))
        		.boxed().collect(Collectors.toList()));
    }
}
