package com.keyin.dsa.numbers;

import com.keyin.dsa.tree.Tree;
import jakarta.persistence.*;

@Entity
public class Number {
    @Id
    @SequenceGenerator(name = "numbers_sequence", sequenceName = "numbers_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "numbers_sequence")
    private long numberId;
    private String numberInput;
    @OneToOne(cascade = CascadeType.ALL)
    private Tree root;

    // Getters and setters
    public long getNumberId() {
        return numberId;
    }

    public void setNumberId(long numberId) {
        this.numberId = numberId;
    }

    public String getNumberInput() {
        return numberInput;
    }

    public void setNumberInput(String numberInput) {
        this.numberInput = numberInput;
    }

    public Tree getRoot() {
        return root;
    }

    public void setRoot(Tree root) {
        this.root = root;
    }
}
