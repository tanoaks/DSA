package tree;

import core.Node;

import java.util.List;

public class TestBst {
    public static void main(String[] args) {


        BSTree<String> newy=  new BSTree<>();
        newy.add("a");
        newy.add("b");
        newy.add("c");
        newy.add("d");
        newy.add("e");
        newy.add("f");
        newy.add("g");

        newy.listAll().stream().map(Node::getValue).forEach(System.out::println);
        System.out.println(newy.depth());
        newy.reBalance();
        newy.listAll().stream().map(Node::getValue).forEach(System.out::println);
        System.out.println(newy.depth());
    }
}
