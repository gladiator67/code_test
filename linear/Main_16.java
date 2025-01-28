package com.aaa.linear;        // https://mundol-colynn.tistory.com/126

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main_16 {

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0 ; i<progresses.length; i++) {
            queue.add((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }

        while(!queue.isEmpty()) {
            int minDays = queue.poll();
            int count=1;

            while(!queue.isEmpty() && queue.peek() <= minDays) {
                queue.poll();
                count++;
            }

            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        // int[] progresses = new int[]{93, 30, 55};
        // int[] speeds = new int[]{1,30,5};
        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.stream(solution(progresses, speeds))
        		.boxed().collect(Collectors.toList()));
    }
}
