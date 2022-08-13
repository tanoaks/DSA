package tree;

import core.Node;

public class TestBst {
    public static void main(String[] args) {
        BSTree<String> my = new BSTree<>();
        my.add("g");
        my.add("ga");
        my.add("gar");
        my.add("ad");
        my.add("aer");
        my.listAll().stream().map(Node::getValue).forEach(System.out::println);

    }
}
