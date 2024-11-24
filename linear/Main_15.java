package com.aaa.linear;

import java.util.ArrayDeque;

public class Main_15 {

    public static int solution(int N, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 1 ; i<=N ; i++) {
            queue.addLast(i);
        }

        while(queue.size() > 1) {
            for(int j = 0 ; j<k-1 ; j++) {
                queue.addLast(queue.pollFirst());
            }
            queue.pollFirst();
        }

        return queue.pollFirst();
    }

    public static void main(String[] args) {
        int n = 5, k = 2;

        System.out.println(solution(n, k));
    }
}
