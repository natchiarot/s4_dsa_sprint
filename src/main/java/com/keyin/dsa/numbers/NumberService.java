package com.keyin.dsa.numbers;

import com.keyin.dsa.tree.Tree;
import com.keyin.dsa.tree.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        return numberRepository.save(newNumber);
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
