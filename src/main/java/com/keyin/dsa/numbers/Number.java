package com.keyin.dsa.numbers;
import lombok.*;
import com.keyin.dsa.tree.Tree;
import jakarta.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Number {
    @Id
    @SequenceGenerator(name = "numbers_sequence", sequenceName = "numbers_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "numbers_sequence")
    private long numberId;
    private String numberInput;
    @OneToOne(cascade = CascadeType.ALL)
    private Tree root;

    public Number(String numberInput) {
        this.numberInput = numberInput;
    }
}
