package com.aaa.linear;

import java.util.Stack;

public class Main_08 {

    private static Stack<Character> stack = new Stack<>();

    public static boolean solution(String s) {
        for(int i=0 ; i<s.length() ; i++) {
            Character c = s.charAt(i);

            if (stack.isEmpty() || c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(solution("([](){}"));
    }
}