package com.aaa.linear;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main_17 {

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1)); 
        Queue<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2)); 
        Queue<String> queueGoal = new ArrayDeque<>(Arrays.asList(goal)); 
        
        while(!queueGoal.isEmpty()) {

            if(!queue1.isEmpty() && queue1.peek().equals(queueGoal.peek())) {
                queueGoal.poll();
                queue1.poll();
            } else if (!queue2.isEmpty() && queue2.peek().equals(queueGoal.peek())){
                queueGoal.poll();
                queue2.poll();
            } else {
                break;
            }
        }
        
        String answer = queueGoal.isEmpty()? "Yes": "No";
        return answer;
    }

    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(solution(cards1, cards2, goal));
    }
}
