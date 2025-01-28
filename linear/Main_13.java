package com.aaa.linear;

import java.util.Stack;

public class Main_13 {

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        // i ==> row, j ==> column

        Stack<Integer>[] lanes = new Stack[board.length];
        for(int j=0 ; j<lanes.length ; j++) {
            lanes[j] = new Stack<>();
        }   // Lane를 초기화

        for(int i = board.length - 1 ; i>=0 ; i--) {
            for(int j=0 ; j<board[i].length ; j++) {
                if(board[i][j] > 0) {
                    lanes[j].push(board[i][j]) ; 
                }
            }
        }   // 초기화한 Laned에 Board의 값, 즉 인형을 삽입한다. 

        // 상품 바구니 Bucket을 생성하고 작업을 수행합니다.
        Stack<Integer> bucket = new Stack<>();   

        for(int move : moves) {
            if(!lanes[move-1].isEmpty()) {
                int doll = lanes[move-1].pop();

                if(!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},
        				{0,2,5,0,1},{4,2,4,4,2},
        				{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        
        //System.out.println(solution(Arrays.stream(prices).boxed().mapToInt(Integer::intValue).toArray()));
        
        System.out.println(solution(board, moves));
    }
}
