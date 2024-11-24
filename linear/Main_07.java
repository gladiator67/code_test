package com.aaa.linear;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_07 {

    public static Map<Character, int[]> location = new HashMap<>();
    
    public static boolean isValid(int dx, int dy) {
        if(dx >= 0 && dy >= 0 && dx <= 10 && dy <= 10) {
            return true;
        }
        return false;
    }
    
    public static void location_step() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('R', new int[]{1, 0});
        location.put('L', new int[]{-1, 0});
    }
    
    public static int solution(String dirs) {
        location_step();
        int x=5, y=5;

        List<String> answers = new ArrayList<>();

        for(int i=0 ; i< dirs.length() ; i++) {
            int[] offset = location.get(dirs.charAt(i));
            
            int dx = x + offset[0];
            int dy = y + offset[1];
            
            if (!isValid(dx, dy))
                continue;
            
            answers.add(x + " to " + dx + " and " + y + " to " + dy);
            answers.add(dx + " to " + x + " and " + dy + " to " + y);
            
            x = dx;
            y = dy;
        }

        int answer = (int)answers.stream().distinct().count()/2;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }
}
