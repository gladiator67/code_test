package com.aaa.tree;

import java.util.Arrays;

public class Main_25_obj {
	
	// 7
    // A B C
    // B D .
    // C E F
    // E . .
    // F . G
    // D . .
    // G . .
    
    public static class Node {
        char data;
        Node left;
        Node right;

        Node(char data){
            this.data = data;
        }
    }

    public static Node root;

    public static void createNode(char data, char leftData, char rightData) {
        if(root == null) {
            root = new Node(data);
            root.left = leftData != '.' ? new Node(leftData) : null;
            root.right = rightData != '.' ? new Node(rightData) : null;
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public static void searchNode(Node node, char data, 
    									char leftData, char rightData) {
        if(node == null) {
            return;
        } else if (node.data == data) {
            node.left = leftData != '.' ? new Node(leftData) : null;
            node.right = rightData != '.' ? new Node(rightData) : null;
        } else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    public static String preorder_obj(Node node) {
        StringBuilder result = new StringBuilder();
        if (node != null) {
            result.append(node.data);

            if (node.left != null) {
                result.append(preorder_obj(node.left));
            }
            if (node.right != null) {
                result.append(preorder_obj(node.right));
            }
        }
        return result.toString();
    }

    public static String inorder_obj(Node node) {
        StringBuilder result = new StringBuilder();
        if (node != null) {
            if (node.left != null) {
                result.append(inorder_obj(node.left));
            }
            result.append(node.data);

            if (node.right != null) {
                result.append(inorder_obj(node.right));
            }
        }
        return result.toString();
    }

    public static String postorder_obj(Node node) {
        StringBuilder result = new StringBuilder();
        if (node != null) {
            if (node.left != null) {
                result.append(postorder_obj(node.left));
            }
            if (node.right != null) {
                result.append(postorder_obj(node.right));
            }

            result.append(node.data);
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        char[] array_nodes = {'A','B','C','D',0,'E','F',0,0,0,0,0,0,0,'G'};
        Arrays.stream(solution_array(array_nodes)).forEach(System.out::println);

        String[] obj_nodes = {"A B C", "B D .", "C E F", "E . .", 
        									"F . G", "D . .", "G . ."};

        for(int i=0 ; i<obj_nodes.length ;i++) {
            String[] data = obj_nodes[i].split(" ");
            char root = data[0].charAt(0);
            char left = data[1].charAt(0);
            char right = data[2].charAt(0);

            createNode(root, left, right);
        }

        System.out.println(preorder_obj(root));
        System.out.println(inorder_obj(root));
        System.out.println(postorder_obj(root));
    }
}
