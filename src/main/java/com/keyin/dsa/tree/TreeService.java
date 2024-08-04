package com.keyin.dsa.tree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TreeService {
    @Autowired
    private TreeRepository treeRepository;

    public Tree getTree(long index) {
        Optional<Tree> result = treeRepository.findById(index);

        if (result.isPresent()) {
            return result.get();
        }

        return null;
    }

    public Tree createTree(Tree newTree) {
        return treeRepository.save(newTree);
    }

    public List<Tree> getAllTrees() {
        return (List<Tree>) treeRepository.findAll();
    }

    public Tree updateTree(Integer index, Tree updatedTree) {
        Tree treeToUpdate = getTree(index);

        treeToUpdate.setTree(updatedTree.getTree());

        return treeRepository.save(treeToUpdate);
    }

    public void deleteTree(long index) {
        treeRepository.delete(getTree(index));
    }

    public Tree findByTree(String tree) {
        return treeRepository.findByTree(tree);
    }
}
