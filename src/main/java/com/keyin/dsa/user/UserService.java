//package com.keyin.dsa.user;
//
//import com.keyin.dsa.tree.Tree;
//import com.keyin.dsa.tree.TreeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private TreeRepository treeRepository;
//
//    public User getUser(long index) {
//        Optional<User> result = userRepository.findById(index);
//
//        if (result.isPresent()) {
//            return result.get();
//        }
//
//        return null;
//    }
//
//    public User createUser(User newUser) {
//        if (newUser.getTree() == null) {
//            System.out.println("No tree entered");
//            return null;
//        } for (Tree tree : newUser.getTree()) {
//            saveTreeRecursively(tree);
//        }
//        return userRepository.save(newUser);
//    }
//
//    private void saveTreeRecursively(Tree tree) {
//        if (tree == null) {
//            return;
//        }
//        if (tree.getLeft() != null) {
//            saveTreeRecursively(tree.getLeft());
//        }
//        if(tree.getRight() != null) {
//            saveTreeRecursively(tree.getRight());
//        }
//        Tree treesInDB = treeRepository.findByValue(tree.getValue());
//        if (treesInDB == null) {
//            treeRepository.save(tree);
//        } else {
//            treeRepository.save(tree);
//        }
//    }
//
//    public List<User> getAllUsers() {
//        return (List<User>) userRepository.findAll();
//    }
//
//    public User updateUser(Integer index, User updatedUser) {
//        User userToUpdate = getUser(index);
//
//        userToUpdate.setUserName(updatedUser.getUserName());
//        userToUpdate.setPassword(updatedUser.getPassword());
//
//        return userRepository.save(userToUpdate);
//    }
//
//    public void deleteUser(long index) {
//        userRepository.delete(getUser(index));
//    }
//
//    public List<User> findUserByUserName(String userName) {
//        return userRepository.findUserByUserName(userName);
//    }
//}
