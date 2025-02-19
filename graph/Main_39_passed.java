package com.aaa.graph;

import java.util.Queue;
import java.util.ArrayDeque;

public class Main_39_passed {
    //기본 step을 지정한다.
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    
    // 지도의 기본 크기를 지정한다.
    public static int N, M;
    // 각 Node에 방문여부를 지정한다.
    public static int[][] visited;

    // 지도상의 Node를 지정할 객체 생성
    public static class Node{
        int y, x;
        public Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
    
    public static int bfs(char start, char end, String[] maps){
        //  깊이 우선 탐색을 위한 Queue 생성
        Queue<Node> queue = new ArrayDeque<>();
        visited = new int[N][M];
        
        // start 점일 경우 깊이 우선 탐색을 시작한다.
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
            
            // 끝점일 경우 계산을 종료한다.
            if (maps[y].charAt(x) == end){
                return visited[y][x] - 1;
            }

            // for loop를 사용하여 각 step을 이동한다.
            for (int i = 0 ; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 지도의 외곽을 벗어나는 경우 계산을 생략한다.
                if(nx < 0 || ny <0 || nx >= M || ny >= N )
                    continue;

                // 이미 통과한 점일 경우 계산을 생략한다.
                if(visited[ny][nx] > 0)
                    continue;

                // 도달한 점인 벽인 경우 계산을 생략한다.
                if(maps[ny].charAt(nx) == 'X')
                    continue;

                // 방문 자료구조를 갱신하고 queue를 update한다.
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
