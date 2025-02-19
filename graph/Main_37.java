package com.aaa.graph;

import java.util.Queue;
import java.util.ArrayDeque;

public class Main_37 {

    // 기본 step을 지정한다.
    private static final int[] rx = {0,0,1,-1};
    private static final int[] ry = {1,-1,0,0};

    // 지도의 위치를 저장하는 객체 생성
    private static class Node {
        int row,col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public static int solution(int[][] maps) {
        int N = maps.length;  // 지도의 y 값 크기
        int M = maps[0].length;  // 지도의 x 값 크기
        int[][] dist = new int[N][M];

        Queue<Node> queue = new ArrayDeque<>();  // Queue 생성
        queue.add(new Node(0,0));  // 넓이 우선 탐색을 시작한다.
        dist[0][0] = 1;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(int i=0; i<4; i++) {
                int nrow = now.row + ry[i];  // 각각의 step 배열을 이용하여 한 step씩 이동
                int ncol = now.col + rx[i];  // 각각의 step 배열을 이용하여 한 step씩 이동

                // 지도의 벽을 넘어서면 계산을 생략한다.
                if(nrow < 0 || ncol < 0 || nrow >= N || ncol >= M) 
                    continue;

                // 지도의 벽을 통과하면 계산을 생략한다.
                if(maps[nrow][ncol] == 0)
                    continue;

                // 노드가 처음 방문하는 경우, queue에 추가하고 거리를 갱신한다.
                if(dist[nrow][ncol] == 0) {
                    queue.add(new Node(nrow,ncol));
                    dist[nrow][ncol] = dist[now.row][now.col] + 1;
                }
            }
        }

        // 최단거리를 반환한다. 목표에 도달하지 못한 경우 -1 반환
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
