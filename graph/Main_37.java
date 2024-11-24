package com.aaa.graph;

import java.util.Queue;
import java.util.ArrayDeque;

public class Main_37 {

    private static final int[] rx = {0,0,1,-1};
    private static final int[] ry = {1,-1,0,0};

    private static class Node {
        int row,col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public static int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        int[][] dist = new int[N][M];

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0));
        dist[0][0] = 1;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(int i=0; i<4; i++) {
                int nrow = now.row + ry[i];
                int ncol = now.col + rx[i];

                if(nrow < 0 || ncol < 0 || nrow >= N || ncol >= M) 
                    continue;

                if(maps[nrow][ncol] == 0)
                    continue;

                if(dist[nrow][ncol] == 0) {
                    queue.add(new Node(nrow,ncol));
                    dist[nrow][ncol] = dist[now.row][now.col] + 1;
                }
            }
        }

        return dist[N-1][M-1] == 0 ? -1 : dist[N-1][M-1];
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},
        				{1,0,1,0,1},
        				{1,0,1,1,1},
        				{1,1,1,0,1},
        				{0,0,0,0,1}};

        System.out.println(solution(maps));
    }
}
