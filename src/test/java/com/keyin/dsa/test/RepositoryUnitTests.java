package com.keyin.dsa.test;

import com.keyin.dsa.numbers.Number;
import com.keyin.dsa.numbers.NumberRepository;
import com.keyin.dsa.tree.TreeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositoryUnitTests {

    @Autowired
    private NumberRepository numberRepository;

    @Autowired
    private TreeRepository treeRepository;

    @Test
    @DisplayName("Test 1: Save Number Test")
    @Order(1)
    @Rollback(value = false)
    public void saveNumberTest() {
        Number number = Number.builder()
                .numberInput("1 25 7 65 5 3")
                .build();

        Number savedNumber = numberRepository.save(number);

        System.out.println(savedNumber);
        Assertions.assertThat(savedNumber).isNotNull();
        Assertions.assertThat(savedNumber.getNumberId()).isGreaterThan(0);
        Assertions.assertThat(savedNumber.getNumberInput()).isEqualTo("1 25 7 65 5 3");
    }

    @Test
    @DisplayName("Test 2: Get All Numbers Test")
    @Order(2)
    public void getListOfNumbersTest() {
        List<Number> numbers = numberRepository.findByNumberInput("1 25 7 65 5 3");

        System.out.println(numbers);
        Assertions.assertThat(numbers.size()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Test 3: Update Number Test")
    @Order(3)
    @Rollback(value = false)
    public void updateNumberTest() {
        Number number = Number.builder()
                .numberInput("2 54 6 3 23 5 1 22")
                .build();
        Number savedNumber = numberRepository.save(number);

        savedNumber.setNumberInput("1 12 43 6 13 4");
        Number updatedNumber = numberRepository.save(savedNumber);

        Assertions.assertThat(updatedNumber).isNotNull();
        Assertions.assertThat(updatedNumber.getNumberInput()).isEqualTo("1 12 43 6 13 4");
    }

    @Test
    @DisplayName("Test 4: Delete Number Test")
    @Order(4)
    @Rollback(value = false)
    public void deleteNumberTest() {
        Number number = Number.builder()
                .numberInput("2 34 12 4 5 3")
                .build();
        Number savedNumber = numberRepository.save(number);

        Assertions.assertThat(savedNumber).isNotNull();
        Assertions.assertThat(savedNumber.getNumberInput()).isEqualTo("2 34 12 4 5 3");

        numberRepository.deleteById(savedNumber.getNumberId());

        Optional<Number> deletedNumber = numberRepository.findById(savedNumber.getNumberId());
        Assertions.assertThat(deletedNumber).isEmpty();
    }
}