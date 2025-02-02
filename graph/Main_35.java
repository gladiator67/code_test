package com.aaa.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main_35 {

    private static List<Integer>[] adjList;
    private static boolean[] visited;
    private static List<Integer> answer;

    private static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n+1];

        for(int i=0 ; i<adjList.length ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n+1];
        answer = new ArrayList<>();

        bfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            answer.add(now);

            for(int next: adjList[now]) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // int[][] graph = {{1,2},{1,3},{2,4},{2,5},{3,6},
        //					{3,7},{4,8},{5,8},{6,9},{7,9}};
        int[][] graph = {{1,3},{3,4},{3,5},{5,2}};
        int start = 1;
        // int n=9;
        int n=5;

        System.out.println(Arrays.stream(solution(graph, start, n))
        						.boxed().collect(Collectors.toList()));
    }
}
