package com.aaa.linear;

import java.util.Stack;

public class Main_10 {

    // "[](){}"   -->	3

    private static String shift(String s) {    // 입력 문자를 회전하는 함수
        String temp = s.substring(1);
        Character first = s.charAt(0);

        System.out.println(temp + first);

        return temp + first;
    }

    private static boolean verificate(String str) {    // Stack을 사용하여 같은 쌍의 괄호를 제거
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
