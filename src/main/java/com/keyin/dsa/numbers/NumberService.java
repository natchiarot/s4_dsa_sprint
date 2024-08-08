package com.keyin.dsa.numbers;

import com.keyin.dsa.BST;
import com.keyin.dsa.tree.Tree;
import com.keyin.dsa.tree.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TransferQueue;

@Service
public class NumberService {
    @Autowired
    private NumberRepository numberRepository;

    @Autowired
    private TreeRepository treeRepository;

    public Number getNumber(long index) {
        Optional<Number> result = numberRepository.findById(index);

        if (result.isPresent()) {
            return result.get();
        }

        return null;
    }

    public Number createNumber(Number newNumber) {
        BST tree = createTree(newNumber.getNumberInput());
        Tree root = convertBSTToTree(tree.getRoot());
        treeRepository.save(root);
        newNumber.setRoot(root);

        return numberRepository.save(newNumber);
    }

    public static BST createTree(String strValue) {
        String[] spl = strValue.split(" ");
        BST tree = new BST();
        for (String s : spl) {
            Integer value = Integer.parseInt(s);
            tree.insert(value);
        }
        return tree;
    }

    private Tree convertBSTToTree(Tree numberInput) {
        if(numberInput == null) {
            return null;
        }

        Tree treeNode = new Tree();
        treeNode.setValue(numberInput.getValue());

        treeNode.setLeft(convertBSTToTree(numberInput.getLeft()));
        treeNode.setRight(convertBSTToTree(numberInput.getRight()));

        return treeNode;
    }

    public List<Number> getAllNumbers() {
        return (List<Number>) numberRepository.findAll();
    }

    public Number updateNumber(Integer index, Number updatedNumber) {
        Number numberToUpdate = getNumber(index);

        numberToUpdate.setNumberInput(updatedNumber.getNumberInput());
        numberToUpdate.setRoot(updatedNumber.getRoot());

        return numberRepository.save(numberToUpdate);
    }

    public void deleteNumber(long index) {
        numberRepository.delete(getNumber(index));
    }

    public List<Number> findByNumberInput(String numberInput) {
        return numberRepository.findByNumberInput(numberInput);
    }
}
