package com.aaa.linear;

import java.util.Stack;

public class Main_10 {

    // "[](){}"   -->	3

    private static String shift(String s) {
        String temp = s.substring(1);
        Character first = s.charAt(0);

        System.out.println(temp + first);

        return temp + first;
    }

    private static boolean verificate(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < str.length() ; i++) {
            Character c = str.charAt(i);

            if (stack.isEmpty() || c == '[' || c == '{' || c == '(' ) {
                stack.push(c);
            } else if(c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if(c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if(c == ')' && stack.peek() == '(') {
                stack.pop();
            }
        }    
        
        if(stack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0 ; i<s.length() ; i++) {
            if(verificate(s)) {
                answer++;
            }

            s = shift(s);
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution("}]()[{"));
        //System.out.println(solution("[](){}"));
    }
}
