package com.keyin.dsa;

import com.keyin.dsa.tree.Tree;

public class BST {
    private Tree root;

    public Tree insert(Tree x, Integer value) {
        if (x == null) {
            return new Tree(value);
        }
        int compare = value.compareTo(x.getValue());
        if (compare < 0) {
            x.setLeft(insert(x.getLeft(), value));
        } else if (compare > 0) {
            x.setRight(insert(x.getRight(), value));
        }
        return x;
    }

    public void insert(Integer value) {
        this.root = insert(this.root, value);
    }

    public Tree getRoot() {
        return root;
    }
}