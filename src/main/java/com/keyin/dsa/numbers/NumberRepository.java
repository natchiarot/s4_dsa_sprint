package com.keyin.dsa.numbers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumberRepository extends CrudRepository<Number, Long>  {
    public List<Number> findByNumberInput(String numberInput);
}
