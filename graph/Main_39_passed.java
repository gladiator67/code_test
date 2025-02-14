package com.aaa.graph;

import java.util.Queue;
import java.util.ArrayDeque;

public class Main_39_passed {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int N, M;
    public static int[][] visited;
    
    public static class Node{
        int y, x;
        public Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
    
    public static int bfs(char start, char end, String[] maps){
        Queue<Node> queue = new ArrayDeque<>();
        visited = new int[N][M];
        for (int y = 0 ; y < N; y++){
            for (int x = 0; x < M; x++){
                if (maps[y].charAt(x) == start){
                    queue.add(new Node(y,x));
                    visited[y][x] = 1;
                }
            }
        }

        while (!queue.isEmpty()){
            Node p = queue.poll();
            int y = p.y;
            int x = p.x;
            
            if (maps[y].charAt(x) == end){
                return visited[y][x] - 1;
            }
            
            for (int i = 0 ; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(nx < 0 || ny <0 || nx >= M || ny >= N )
                    continue;

                if(visited[ny][nx] > 0)
                    continue;

                if(maps[ny].charAt(nx) == 'X')
                    continue;

                visited[ny][nx] = visited[y][x] + 1;
                queue.add(new Node(ny, nx));
            }
        }      
        return -1;
    }
        
    public static int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        int way1 = bfs('S','L',maps);
        int way2 = bfs('L','E',maps);
        if (way1 == -1 || way2 == -1){
            return -1;
        }
        else{
            return way1 + way2;
        }
    }
    
    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        // String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};

        System.out.println(solution(maps));
    }
}
