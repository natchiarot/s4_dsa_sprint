package com.keyin.dsa.tree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TreeController {
    @Autowired
    private TreeService treeService;

    @GetMapping("search_tree")
    public Tree searchTree(@RequestParam(value = "userName", required = false) String tree) {
        return treeService.findByTree(tree);
    }

    @GetMapping("trees")
    public List<Tree> getAllTrees() {
        return treeService.getAllTrees();
    }

    @GetMapping("tree/{index}")
    public Tree getTree(@PathVariable Integer index) {
        return treeService.getTree(index);
    }

    @PostMapping("tree")
    public Tree createTree(@RequestBody Tree newTree) {
        return treeService.createTree(newTree);
    }

    @PutMapping("tree/{index}")
    public Tree updatedTree(@PathVariable Integer index, @RequestBody Tree updatedTree) {
        return treeService.updateTree(index, updatedTree);
    }

    @DeleteMapping("tree/{index}")
    public void deleteTree(@PathVariable Integer index) {
        treeService.deleteTree(index);
    }
}
