package com.keyin.dsa.numbers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumbersRepository extends CrudRepository<Numbers, Long>  {
    public List<Numbers> findByRootAndNumbers(int root, String numbers);
}
