package tree;

import core.Node;

import java.util.ArrayList;
import java.util.List;

public class BSTree<T extends Comparable<T>> {

    private Node<T> root;

    Node<T> add(T value) {
        return add(value, root);
    }

    Node<T> add(T value, Node<T> parent) {
        Node<T> newNode;
        // in case no root node
        if (this.root == null) {
            newNode = new Node<>();
            newNode.setValue(value);
            this.root = newNode;
            return newNode;
        } else {
            // parent is null
            if (parent == null) {
                newNode = new Node<>();
                newNode.setValue(value);
                return newNode;
            }//parent > value move to left
            else if (parent.getValue().compareTo(value) > 1) {
                parent.setLeft(add(value, parent.getLeft()));
            } else if (parent.getValue().compareTo(value) < 1) {
                parent.setRight(add(value, parent.getRight()));
            }
        }
        return parent;
    }


    List<Node<T>> listAll() {
        List<Node<T>> list= new  ArrayList();
        return listAll(root,list) ;
    }

    private List<Node<T>> listAll(Node<T> root, List<Node<T>> list) {
        if (root==null){
            return list;
        }
        listAll(root.getLeft(),list);
        list.add(root);
        listAll(root.getRight(),list);
    return list;
    }

    Node<T> rotate() {
        return null;
    }

    int depth() {
        return -1;
    }

}
