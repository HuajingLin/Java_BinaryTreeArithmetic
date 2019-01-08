//
//  Created by huajing lin on 9/4/18.
//  Copyright © 2018 huajing lin. All rights reserved.
//

package binarytreeapp;

import java.io.Serializable;
import java.util.Stack;

public class BinaryTree<E> implements Serializable {

    protected Node<E> root;
    Stack st = new Stack();

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public Node<E> getRoot() {
        return root;
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    public void add(Node parent, Node child, String orientation) {
        if (orientation.equals("left")) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        //preOrderTraverse(root, 1, sb);
        inOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    private void inOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        if (node == null) {
            return;
        }

        if (depth > 1 && node.isLeft) {
            sb.append("(");
        }

        inOrderTraverse(node.left, depth + 1, sb);

        sb.append(node.data.toString());
        st.push(node.data.toString());

        inOrderTraverse(node.right, depth + 1, sb);

        if (depth > 1 && !node.isLeft) {
            sb.append(")");
        }

        //calculate
        if (depth < 3) {
            String str = (String) st.pop();
            int num2 = Integer.parseInt(str);
            String opt = (String) st.pop();
            str = (String) st.pop();
            int num1 = Integer.parseInt(str);
            //System.out.printf("n1:%d,n2:%d, opt:%s\n",num1,num2,opt);
            if (opt.equals("+")) {
                num1 += num2;
                st.push(Integer.toString(num1));
            }
            else if (opt.equals("/")) {
                num1 /= num2;
                st.push(Integer.toString(num1));
            }
            else if (opt.equals("*")) {
                num1 *= num2;
                st.push(Integer.toString(num1));
            }
            if(depth==1){
                str = (String) st.pop();
                sb.append(" = "+ str);
            }
        }

    }

    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append(" ");     //indentation
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }
}
