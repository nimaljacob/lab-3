package com.gl.javafsd.binarysearchtree;

import java.util.Stack;

//Node class
class Node {
 int data;
 Node left, right;

 public Node(int item) {
     data = item;
     left = right = null;
 }
}

//Binary Search Tree class
class BinarySearchTree {
 Node root;

 // Find a pair with a given sum
 public void findPair(Node root, int sum) {
     if (root == null)
         return;

     // Create two stacks to store nodes
     Stack<Node> stack1 = new Stack<Node>();
     Stack<Node> stack2 = new Stack<Node>();

     Node node1 = root;
     Node node2 = root;

     // Traverse the first tree in in-order
     boolean done1 = false;
     boolean done2 = false;

     while (true) {
         // Find the leftmost node in the first tree
         while (!done1) {
             if (node1 != null) {
                 stack1.push(node1);
                 node1 = node1.left;
             } else {
                 if (stack1.isEmpty())
                     done1 = true;
                 else {
                     node1 = stack1.pop();
                     node1 = node1.right;
                     done1 = true;
                 }
             }
         }

         // Find the rightmost node in the second tree
         while (!done2) {
             if (node2 != null) {
                 stack2.push(node2);
                 node2 = node2.right;
             } else {
                 if (stack2.isEmpty())
                     done2 = true;
                 else {
                     node2 = stack2.pop();
                     node2 = node2.left;
                     done2 = true;
                 }
             }
         }

         // If either traversal is done, break out of loop
         if (node1 == null || node2 == null)
             break;

         // Calculate the sum of the nodes
         int currentSum = node1.data + node2.data;

         // If sum is found, print the pair and return
         if (currentSum == sum) {
             System.out.println("Pair found: (" + node1.data + ", " + node2.data + ")");
             return;
         }

         // If sum is less than the current sum, move to the left of the first tree
         else if (currentSum < sum) {
             node1 = node1.right;
             done1 = false;
         }

         // If sum is greater than the current sum, move to the right of the second tree
         else {
             node2 = node2.left;
             done2 = false;
         }
     }

     // If pair not found, print nodes not found
     System.out.println("Nodes not found");
     
  // Create a binary search tree
     BinarySearchTree tree = new BinarySearchTree();
     tree.root = new Node(50);
     tree.root.left = new Node(30);
     tree.root.right = new Node(70);
     tree.root.left.left = new Node(20);
     tree.root.left.right = new Node(40);
     tree.root.right.left = new Node(60);
     tree.root.right.right = new Node(80);
      
     // Find a pair with a given sum
     int Sum = 130;
     tree.findPair(tree.root, sum);

 }
}



