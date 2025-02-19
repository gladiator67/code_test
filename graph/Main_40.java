package com.aaa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_40 {

    public static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static int solution(int N, int[][] road, int K) {
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=0; i<=N ; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : road) {
            adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Node(edge[0], edge[2]));
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.add(new Node(1, 0));
        dist[1] = 0;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            if(dist[now.dest] < now.cost)
                continue;
            
            for(Node next : adjList.get(now.dest)) {
                if(dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    queue.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        int answer = 0;

        for(int i=1 ; i<=N ; i++) {
            if(dist[i] <= K)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        // int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        
        System.out.println(solution(6, road, 4));
    }
}
