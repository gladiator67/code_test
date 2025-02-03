package test.graph;

import java.util.ArrayList;
import java.util.List;

public class JavaAdjacentList {

    private static List<List<Integer>> adjList;
    
    public static void main(String[] args) {
        int[][] graph = {{0,1},{0,2},{1,0},{1,3},{1,4},{2,0},{2,5},{2,6},{3,1},
                {3,7},{4,1},{4,7},{5,2},{5,7},{6,2},{6,7},{7,3},{7,4},{7,5},{7,6}};
        int n=8;

        // Adjacent List 초기화
        adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adjacent List 생성
        for(int[] edge: graph) {
            adjList.get(edge[0]).add(edge[1]);
        }

        // Adjacent List 출력
        for(int i=0; i<adjList.size(); i++) {
            List<Integer> node = adjList.get(i);
            System.out.print("node" + "[" + i + "] -> ");

            for(int j=0; j<node.size(); j++) {
                System.out.print(node.get(j) + " ");
            }

            System.out.println();
            
            // node[0] -> 1 2 
            // node[1] -> 0 3 4
            // node[2] -> 0 5 6
            // node[3] -> 1 7
            // node[4] -> 1 7
            // node[5] -> 2 7
            // node[6] -> 2 7
            // node[7] -> 3 4 5 6
        }
    }
}
