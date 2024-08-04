package com.keyin.dsa.numbers;

import com.keyin.dsa.tree.Tree;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Numbers {
    @Id
    @SequenceGenerator(name = "numbers_sequence", sequenceName = "numbers_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "numbers_sequence")
    private long numbersId;
    private int root;
    private String numbers;
    @OneToOne
    private Tree tree;

    public long getNumbersId() {
        return numbersId;
    }

    public void setNumbersId(long numbersId) {
        this.numbersId = numbersId;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}
