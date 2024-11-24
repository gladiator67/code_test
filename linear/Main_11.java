package com.aaa.linear;

import java.util.Stack;

public class Main_11 {

    public static int solution(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i<s.length() ; i++) {
            char c = s.charAt(i);

            if(!stack.isEmpty() && (char)stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        int answer = stack.isEmpty() ? 1 : 0;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaac"));
    }
}
