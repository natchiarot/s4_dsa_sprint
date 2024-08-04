package com.keyin.dsa.user;

import com.keyin.dsa.numbers.Numbers;
import com.keyin.dsa.numbers.NumbersRepository;
import com.keyin.dsa.tree.Tree;
import com.keyin.dsa.tree.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NumbersRepository numbersRepository;

    @Autowired
    private TreeRepository treeRepository;

    public User getUser(long index) {
        Optional<User> result = userRepository.findById(index);

        if (result.isPresent()) {
            return result.get();
        }

        return null;
    }

    public User createUser(User newUser) {
        if (newUser.getNumbers() == null) {
            System.out.println("No resume entered");
            return null;
        } for (Numbers numbers : newUser.getNumbers()) {
            if (numbers.getTree() != null) {
                Tree tree = numbers.getTree();
                Tree treeInDB = treeRepository.findByTree(tree.getTree());
                tree = treeRepository.save(tree);
                if (treeInDB == null) {
                    tree = treeRepository.save(tree);
                } else {
                    tree = treeInDB;
                }
                numbers.setTree(tree);
            } else {
                System.out.println("No tree associated with numbers");
                return null;
            }

            List<Numbers> numbersInDB = numbersRepository.findByRootAndNumbers(numbers.getRoot(), numbers.getNumbers());
            if (numbersInDB.isEmpty()) {
                numbersRepository.save(numbers);
            } else {
                numbers = numbersInDB.get(0);
                numbersRepository.save(numbers);
            }
        }
        return userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User updateUser(Integer index, User updatedUser) {
        User userToUpdate = getUser(index);

        userToUpdate.setUserName(updatedUser.getUserName());
        userToUpdate.setPassword(updatedUser.getPassword());

        return userRepository.save(userToUpdate);
    }

    public void deleteUser(long index) {
        userRepository.delete(getUser(index));
    }

    public List<User> findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }
}
