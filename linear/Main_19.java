package com.aaa.linear;

import java.util.HashMap;
import java.util.Map;

public class Main_19 {

    public static String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        // 완주한 사랑을 key로 설정하여 Map을 생성
        for(String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 지원자를 완주한 사람의 Map에서 삭제하며 그값이 0이 되었을때 해당 이름을 반환
        for(String name : participant) {
            if(map.getOrDefault(name, 0) == 0) {
                return name;
            }

            map.put(name, map.get(name) -1);
        }

        return null;
    }

    public static void main(String[] args) {
        // String[] participant = {"leo", "kiki", "eden"};
        // String[] completion = {"eden", "kiki"};
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
    }
}
