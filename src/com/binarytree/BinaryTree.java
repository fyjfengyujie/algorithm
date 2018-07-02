package com.binarytree;

import java.util.Stack;

public class BinaryTree {

    static class Node{
        int val;
        Node left;
        Node right;

        Node (int val,Node left,Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static void preOrder(Node root){
        Stack<Node> stack = new Stack<>();
        if(root == null){
            return;
        }
        stack.push(root);
        Node p = null;
        while (!stack.empty()){
            p = stack.pop();
            if (p != null){
                System.out.println(p.val);
                stack.push(p.right);
                stack.push(p.left);
            }
        }
    }

    public static void midOrder(Node root){
        Stack<Node> stack = new Stack<>();
        if(root == null){
            return;
        }
        Node p = root;
        while (!stack.empty() || p != null){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p.val);
            p = p.right;
        }
    }

    public static void postOrder(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node p = root;
        Node pre = p;
        while (p!=null || !stack.empty()){
            while (p!=null){
                //循环把左孩子压入
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                Node temp = stack.peek().right;
                if(temp == null || temp == pre){
                    p = stack.pop();
                    System.out.println(p.val);
                    pre = p;
                    p = null;
                }else {
                    p = temp;
                }
            }
        }
    }

    public static void main(String [] args){
        Node node1 = new Node(1,null,null);
        Node node2 = new Node(2,null,null);
        Node node3 = new Node(3,null,null);
        Node node4 = new Node(4,null,null);
        Node node5 = new Node(5,null,null);
        Node node6 = new Node(6,null,null);
        Node node7 = new Node(7,null,null);

        node1.left = node2; node1.right = node3;
        node2.left = node4; node2.right = node5;
        node3.right = node6;
        node5.left = node7;

//        preOrder(node1);
//        midOrder(node1);
        postOrder(node1);
    }

}
