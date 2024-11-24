package com.aaa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main_36 {

    private static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static int[] solution(int[][] graph, int start, int n) {

        List<Node>[] adjList = new ArrayList[n];
        for(int i=0 ; i<adjList.length ; i++) {
            adjList[i] = new ArrayList<>();
        } 

        for(int[] edge : graph) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        Queue<Node> queue = new PriorityQueue<>((n1, n2) 
        						-> Integer.compare(n1.cost, n2.cost));
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            if(dist[now.dest] < now.cost)
                continue;

            for(Node next : adjList[now.dest]) {
                if(dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;

                    queue.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        
        return dist;
    }
    
    public static void main(String[] args) {
        int[][] graph = {{0,1,4},{0,2,4},{0,4,1},{1,2,6},{2,3,8},{3,0,5},
        										{3,1,2},{4,2,2}}; 
        // int[][] graph = {{1,1,0},{1,2,4},{1,3,2},{2,3,3},{2,4,2},
        //						{2,5,3},{3,2,1},{3,4,4},{3,5,5},{5,4,1}};
        // int[][] graph = {{0,1,9},{0,2,3},{1,0,5},{2,1,1}};
        // int[][] graph = {{0,1,1},{1,2,5},{2,3,1}};
        int start = 0;
        int n=5;
        // int n=4;

        System.out.println(Arrays.stream(solution(graph, start, n))
        							.boxed().collect(Collectors.toList()));
    }
}
