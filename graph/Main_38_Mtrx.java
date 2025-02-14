package com.aaa.graph;

public class Main_38_Mtrx {

    private static boolean[] visited;
    
    public static void dfs(int i, int[][] computers) {
        visited[i] = true;

        for(int j=0 ; j<computers[i].length ; j++) {
            if(computers[i][j] == 1 && visited[j] == false) {
                dfs(j, computers);
            }
        }
    }
    
    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for(int i=0 ; i<n ; i++) {
            if(visited[i] == false) {
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        // int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};

        System.out.println(solution(3, computers));
    }
}
