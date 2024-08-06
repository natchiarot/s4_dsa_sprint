package com.keyin.dsa;

import com.keyin.dsa.tree.Tree;

public class Test {
    public static BST createTree(String strValue) {
        String[] spl = strValue.split(" ");
        BST tree = new BST();
        for (String s : spl) {
            Integer value = Integer.parseInt(s);
            tree.insert(value);
        }
        return tree;
    }

    public static void main(String[] args) {
        String s = "20 40 30 1 23 54 3 21 34";
        BST bst = createTree(s);
        Tree root = bst.getRoot();
        printTree(root, "", true);
    }

    private static void printTree(Tree node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            System.out.println(node.getValue());

            printTree(node.getLeft(), indent, false);
            printTree(node.getRight(), indent, true);
        }
    }
}