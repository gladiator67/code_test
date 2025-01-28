package com.aaa.linear;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main_12 {

    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);  // 인덱스를 저장. 여기서 인덱스는 시간을 의미. 초기값으로  0 을 지정

        for(int i=1 ; i< n ; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i-j;
            }   // Stack에 저장하다가 값이 하강하면 Stack에서 그 인덱스를 제거하고 answer 배열에 저장

            stack.push(i);  // 값이 상승하면 Stack에 값을 저장
        }

        while(!stack.isEmpty()){   // Stack에 저장된 값을 answer 배열에 불어와 저장 
            int j = stack.pop();
            answer[j] = n-j-1;  // j는 0부터 시작됨
        }
                
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 2, 3};
        
        //System.out.println(solution(Arrays.stream(prices)
        //		.boxed().mapToInt(Integer::intValue).toArray()));
        
        System.out.println(Arrays.stream(solution(prices))
        		.boxed().collect(Collectors.toList()));
    }
}
