package tree;

import core.Node;

import java.util.ArrayList;
import java.util.List;

public class BSTree<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> add(T value) {
        return add(value, root);
    }

    private Node<T> add(T value, Node<T> parent) {
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
        List<Node<T>> list = new ArrayList();
        return listAll(root, list);
    }

    private List<Node<T>> listAll(Node<T> root, List<Node<T>> list) {
        if (root == null) {
            return list;
        }
        listAll(root.getLeft(), list);
        list.add(root);
        listAll(root.getRight(), list);
        return list;
    }

    public void rotate() {
        root = rotate(root);
    }

    public Node<T> rotate(Node<T> node) {
        if (node == null)
            return null;
        Node<T> temp = rotate(node.getLeft());
        node.setLeft(rotate(node.getRight()));
        node.setRight(temp);
        return node;
    }

    public int depth() {
        return depth(root);
    }

    private int depth(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
    }

    private Node<T> fromList(List<T> list) {
        int start = 0;
        int last = list.size()-1;
        this.root = fromList(list, start, last);
        return root;
    }

    private Node<T> fromList(List<T> list, int start, int last) {
        int mid = (start + last) / 2;
        if (start > last) {
            return null;
        }
            Node<T> ret = new Node<>();
            ret.setValue(list.get(mid));
            ret.setLeft(fromList(list,start,mid-1));
            ret.setRight(fromList(list,mid+1,last));
            return ret;
        }

        public Node<T> reBalance(){
        Node<T> reb = fromList(this.listAll().stream().map(Node::getValue).toList());
        this.root =reb;
        return reb;
        }

}
