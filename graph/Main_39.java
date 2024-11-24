package com.aaa.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main_39 {   // 통과하지 못했음!!!!!!

    private static final int[] dx = {0,0,1,-1};
    private static final int[] dy = {1,-1,0,0};
    public static int N, M;
    public static char[][] map;
    
    private static class Node {
        int nx, ny;
        public Node(int nx, int ny){
            this.nx = nx;
            this.ny = ny;
        }
    }

    public static int bfs(Node start, Node end) {
        int[][] dist = new int[N][M];
        
        Queue<Node> queue = new ArrayDeque<>();
        dist[start.ny][start.nx] = 1;
        queue.add(start);
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            for(int i=0 ; i<4 ; i++) {
                int nextX = now.nx + dx[i];
                int nextY = now.ny + dy[i];
                
                if(nextX<0 || nextY<0 || nextX>=M || nextY >=N)
                    continue;
                
                if(dist[nextY][nextX]>0)
                    continue;
                
                if(map[nextY][nextX] == 'X')
                    continue;
                
                dist[nextY][nextX] = dist[now.ny][now.nx] + 1;
                queue.add(new Node(nextX, nextY));
                
                if(nextX == end.nx && nextY == end.ny)
                    return dist[end.ny][end.nx] -1;
            }
        }
        
        return -1;
    }

    
    public static int solution(String[] maps) {
        N = maps.length;   // Y축 (행,Row)
        M = maps[0].length();   // X축  (열,Column)
        
        map = new char[N][M];
        for(int i=0 ; i<N ; i++) {
            map[i] = maps[i].toCharArray();
        }
        Node start = null, end = null, lever = null;

        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<M ;j++) {
                if(map[i][j] == 'S') {
                    start = new Node(j, i);
                } else if(map[i][j] == 'L') {
                    lever = new Node(j,i);
                } else if(map[i][j] == 'E') {
                    end = new Node(j, i);
                }
            }
        }
        
        int way1 = bfs(start, lever);
        int way2 = bfs(lever, end);

        if(way1 == -1 || way2 == -1)
            return -1;
        else 
            return way1+way2;
    }

    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        // String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};

        System.out.println(solution(maps));
    }
}
