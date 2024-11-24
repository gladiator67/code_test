package com.aaa.linear;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class Main_23 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> reportedUser = new HashMap<>(); 
        Map<String, Integer> idMap = new HashMap<>(); 
        int[] answer = new int[id_list.length];

        for (int i=0 ; i<id_list.length ; i++) {
            idMap.put(id_list[i], i);
            reportedUser.put(id_list[i], new HashSet<>());
        }

        for(int i = 0 ; i<report.length ; i++) {
            String[] s = report[i].split(" ");
            String from = s[0];
            String to = s[1];

            reportedUser.get(to).add(from);
        }

        for(String name : reportedUser.keySet()) {
            if(reportedUser.get(name).size() >= k) {
                for(String id : reportedUser.get(name)) {
                    answer[idMap.get(id)] +=1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo",
        	"muzi neo","apeach muzi"};
        int k=2;

        System.out.println(Arrays.stream(solution(id_list, report, k))
        	.boxed().collect(Collectors.toList()));
    }
}
