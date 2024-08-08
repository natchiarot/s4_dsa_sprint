package com.keyin.dsa.tree;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tree {
    @Id
    @SequenceGenerator(name = "tree_sequence", sequenceName = "tree_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "tree_sequence")
    @JsonIgnore
    private long treeId;
    private int value;
    @OneToOne(cascade = CascadeType.ALL)
    private Tree left;
    @OneToOne(cascade = CascadeType.ALL)
    private Tree right;

    public Tree() {

    }

    public Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public long getTreeId() {
        return treeId;
    }

    public void setTreeId(long treeId) {
        this.treeId = treeId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
