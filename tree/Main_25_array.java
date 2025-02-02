package com.aaa.tree;

import java.util.Arrays;

public class Main_25_array {

    // 7
    // A B C
    // B D .
    // C E F
    // E . .
    // F . G
    // D . .
    // G . .     https://stdio-han.tistory.com/138
    
    // [A,B,C,D,,E,F,,,,,,,,G]
   
    private static String preorder_array(char[] nodes, int idx) {
        if(idx >= nodes.length) {
            return "";
        }
        return nodes[idx] + preorder_array(nodes, 2*idx + 1) 
        		+ preorder_array(nodes, 2*idx + 2);
    }

    private static String inorder_array(char[] nodes, int idx) {
        if(idx >= nodes.length) {
            return "";
        }
        return inorder_array(nodes, 2*idx + 1) + nodes[idx] 
        		+ inorder_array(nodes, 2*idx + 2);
    }

    private static String postorder_array(char[] nodes, int idx) {
        if(idx >= nodes.length) {
            return "";
        }
        return postorder_array(nodes, 2*idx + 1) 
        		+ postorder_array(nodes, 2*idx + 2) + nodes[idx];
    }

    public static String[] solution_array(char[] nodes) {
        String pre_array = preorder_array(nodes, 0);
        String in_array = inorder_array(nodes, 0);
        String post_array = postorder_array(nodes, 0);

        return new String[] {pre_array,in_array, post_array};
    }
    
    public static void main(String[] args) {
        char[] array_nodes = {'A','B','C','D',0,'E','F',0,0,0,0,0,0,0,'G'};
        Arrays.stream(solution_array(array_nodes)).forEach(System.out::println);
	}
}
