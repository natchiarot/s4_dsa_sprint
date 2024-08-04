package com.keyin.dsa.tree;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends CrudRepository<Tree, Long>  {
    public Tree findByTree(String tree);
}