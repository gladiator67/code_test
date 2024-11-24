package com.aaa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main_34 {

    private static List<Integer>[] adjList;
    private static boolean[] visited;
    private static List<Integer> answer;

    public static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n+1];

        for(int i=0 ; i<adjList.length ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n+1];
        answer = new ArrayList<>();

        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int now) {
        visited[now] = true;
        answer.add(now);

        for(int next : adjList[now]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
    
    public static void main(String[] args) {
        // int[][] graph = {{1,2},{2,3},{3,4},{4,5}};
        int[][] graph = {{1,2},{1,3},{2,4},{2,5},{3,6},{5,6}};
        int start = 1;
        // int n=5;
        int n=6;

        System.out.println(Arrays.stream(solution(graph, start, n))
        		.boxed().collect(Collectors.toList()));
    }
}
