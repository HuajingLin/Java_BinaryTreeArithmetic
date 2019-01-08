//
//  Created by huajing lin on 9/4/18.
//  Copyright © 2018 huajing lin. All rights reserved.
//
/*

Use binary tree to implement arithmetic
1. read the expression of arithmetic from text file.
   for example: 4 2 + 10 5 / * 
2. calculate: ((4+2)*(10/5))
3. print result: ((4+2)*(10/5)) = 12
*/
package binarytreeapp;

public class BinaryTreeApp {

    public static void main(String[] args) {
        
        System.out.println("Read the file:");
        ReadTxtFile readfile = new ReadTxtFile();
        String expression = readfile.Read();
        System.out.println(expression);

        String[] array = expression.split(" ");
        Node n1 = new Node(array[0]);
        Node n2 = new Node(array[1]);
        Node n3 = new Node(array[2]);
        Node n4 = new Node(array[3]);
        Node n5 = new Node(array[4]);
        Node n6 = new Node(array[5]);
        Node n7 = new Node(array[6]);
        BinaryTree bt = new BinaryTree(n7);
        Node root = bt.getRoot();
        bt.add(root, n3, "left");
        bt.add(root, n6, "right");
        bt.add(n3, n1, "left");
        bt.add(n3, n2, "right");
        bt.add(n6, n4, "left");
        bt.add(n6, n5, "right");
        
        System.out.println("\nDo an inorder traverse of tree, \nthen display the result:");
        System.out.println(bt.toString());
    }

}
