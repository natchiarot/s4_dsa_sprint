package com.keyin.dsa.numbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class NumbersController {
    @Autowired
    private NumbersService numbersService;

    @GetMapping("search_number")
    public List<Numbers> searchNumbers(@RequestParam(value = "root", required = false) int root, @RequestParam(value = "numbers", required = false) String numbers) {
        return numbersService.findByRootAndNumbers(root, numbers);
    }

    @GetMapping("numbers")
    public List<Numbers> getAllNumbers() {
        return numbersService.getAllNumbers();
    }

    @GetMapping("number/{index}")
    public Numbers getNumbers(@PathVariable Integer index) {
        return numbersService.getNumbers(index);
    }

    @PostMapping("number")
    public Numbers createNumbers(@RequestBody Numbers newNumbers) {
        return numbersService.createNumbers(newNumbers);
    }

    @PutMapping("number/{index}")
    public Numbers updateNumbers(@PathVariable Integer index, @RequestBody Numbers updatedNumbers) {
        return numbersService.updateNumbers(index, updatedNumbers);
    }

    @DeleteMapping("number/{index}")
    public void deleteNumbers(@PathVariable Integer index) {
        numbersService.deleteNumbers(index);
    }
}
