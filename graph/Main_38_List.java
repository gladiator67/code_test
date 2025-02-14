package test.graph;

import java.util.ArrayList;
import java.util.List;

public class Main_38_List {

    private static List<List<Integer>> adjList;
    private static boolean[] visited;
    private static List<Integer> node = new ArrayList<>();

    private static void dfs(int now) {
        visited[now] = true;
        node.add(now);   // 각 node를 담는다.

        for(int next : adjList.get(now)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int num = 0;
        
        // Adjacent List 초기화
        adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adjacent List 생성
        for(int[] edge: computers) {
            adjList.get(edge[0]).add(edge[1]);
        }

        // 모든 노드에 대해 dfs를 수행한다. 단, 연결되어 있으면 실행하지 않는다.
        for(int i=0 ; i<n ; i++) {
            if(visited[i] == false) {
                dfs(i);
                num++;  // dfs를 실행한 횟수를 증가시켜 네트워크 갯수를 추가한다.
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int[][] computers = {{0,1},{1,0},{2,2}};
        int n = 3;

        int network = solution(n, computers);

        System.out.println(network);  // 네트워크 갯수를 출력한다.
        node.stream().forEach(System.out::print);  // 모든 Node를 출력한다.
    }
}

