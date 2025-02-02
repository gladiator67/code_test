package com.aaa.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main_27 {

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> parentMap = new HashMap<>();  // 판매원의 부모노드 생성
        Map<String, Integer> memberIndexMap = new HashMap<>();  // 판매원의 ID를 index로 생성

        // 두 Map 객체를 초기화
        for(int i=0 ; i<enroll.length ; i++) {
            parentMap.put(enroll[i], referral[i]);
            memberIndexMap.put(enroll[i], i);
        }

        for(int i=0 ; i<seller.length ; i++) {
            String curName = seller[i];
            int profit = amount[i]*100;

            while(!curName.equals("-")) {   // 최상위 노드까지 loop
                int profit4Parent = profit/10;
                int curProfit = profit - profit4Parent;

                answer[memberIndexMap.get(curName)] += curProfit;

                curName = parentMap.get(curName);  // 부모 노드로 이동하여 다시 정산
                profit /= 10;  // 부모노드로 이동하여 이익을 다시 정산. 10% 차감

                if(profit < 1) {
                    break;
                }
            }
        }

        return answer;
    }

        public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.stream(solution(enroll, referral, seller, amount))
        		.boxed().collect(Collectors.toList()));
    }
}
