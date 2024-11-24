package com.aaa.linear;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main_12 {

    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1 ; i< n ; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i-j;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int j = stack.pop();
            answer[j] = n-j-1;
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
