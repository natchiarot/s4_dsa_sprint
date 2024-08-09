package com.keyin.dsa.tree;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
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
}
