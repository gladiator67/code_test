package com.aaa.dynam;

public class Main_72 {

    private static int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];

        for(int i=1 ; i<N ; i++) {
            dp[i][0] = triangle[i][0] + dp[i-1][0];

            for(int j=1 ; j<=i ;j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }

            dp[i][i] = triangle[i][i] + dp[i-1][i-1];
        }
        
        int answer = 0;

        for(int j=0 ; j<N ; j++) {
            answer = Math.max(answer, dp[N-1][j]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};
        
        System.out.println(solution(triangle));
    }
}
