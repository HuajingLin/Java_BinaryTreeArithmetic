/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreeapp;

public class Node<E> {

    E data;
    Node<E> left;
    Node<E> right;
    boolean isLeft;

    public Node(E data) {
        this.data = data;
        left = null;
        right = null;
        isLeft = true;
    }

    public void setTypeOfChild(boolean isLeft) {
        this.isLeft = isLeft;
    }

    public void setLeft(Node<E> node) {
        left = node;
        node.setTypeOfChild(true);
    }

    public void setRight(Node<E> node) {
        right = node;
        node.setTypeOfChild(false);
    }
}
