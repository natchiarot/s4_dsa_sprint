package com.keyin.dsa.numbers;

import com.keyin.dsa.tree.Tree;
import com.keyin.dsa.tree.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NumbersService {
    @Autowired
    private NumbersRepository numbersRepository;

    @Autowired
    private TreeRepository treeRepository;

    public Numbers getNumbers(long index) {
        Optional<Numbers> result = numbersRepository.findById(index);

        if (result.isPresent()) {
            return result.get();
        }

        return null;
    }

    public Numbers createNumbers(Numbers newNumbers) {
        if (newNumbers.getTree() != null) {
            Tree tree = newNumbers.getTree();
            Tree treeInDB = treeRepository.findByTree(tree.getTree());

            if (treeInDB == null) {
                tree = treeRepository.save(tree);
            }
            newNumbers.setTree(tree);
        }
        return numbersRepository.save(newNumbers);
    }

    public List<Numbers> getAllNumbers() {
        return (List<Numbers>) numbersRepository.findAll();
    }

    public Numbers updateNumbers(Integer index, Numbers updatedNumbers) {
        Numbers numbersToUpdate = getNumbers(index);

        numbersToUpdate.setRoot(updatedNumbers.getRoot());
        numbersToUpdate.setNumbers(updatedNumbers.getNumbers());
        numbersToUpdate.setTree(updatedNumbers.getTree());

        return numbersRepository.save(numbersToUpdate);
    }

    public void deleteNumbers(long index) {
        numbersRepository.delete(getNumbers(index));
    }

    public List<Numbers> findByRootAndNumbers(int root, String numbers) {
        return numbersRepository.findByRootAndNumbers(root, numbers);
    }
}
