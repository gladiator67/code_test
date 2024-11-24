package com.aaa.linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main_21 {

    public static String[] solution(String[] record) {
        Map<String, String>  msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        Map<String, String> uid = new HashMap<>();
        for(String s : record) {
            String[] cmd = s.split(" ");
            if(cmd.length == 3) {
                uid.put(cmd[1], cmd[2]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        for(String s : record) {
            String[] cmd = s.split(" ");
            if(msg.containsKey(cmd[0]) && uid.containsKey(cmd[1])) {
                answer.add(uid.get(cmd[1]) + msg.get(cmd[0]));
            }
        }
        
        return answer.toArray(String[]::new);
    }    

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
        	"Leave uid1234","Enter uid1234 Prodo",
        	"Change uid4567 Ryan"};

        System.out.println(Arrays.stream(solution(record))
        			.collect(Collectors.toList()));
    }
}
