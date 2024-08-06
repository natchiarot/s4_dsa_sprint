package com.keyin.dsa.numbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NumberController {
    @Autowired
    private NumberService numberService;

    @GetMapping("search_number")
    public List<Number> searchNumber(@RequestParam(value = "numbers", required = false) String numberInput) {
        return numberService.findByNumberInput(numberInput);
    }

    @GetMapping("numbers")
    public List<Number> getAllNumbers() {
        return numberService.getAllNumbers();
    }

    @GetMapping("number/{index}")
    public Number getNumber(@PathVariable Integer index) {
        return numberService.getNumber(index);
    }

    @PostMapping("number")
    public Number createNumber(@RequestBody Number newNumber) {
        return numberService.createNumber(newNumber);
    }

    @PutMapping("number/{index}")
    public Number updateNumber(@PathVariable Integer index, @RequestBody Number updatedNumber) {
        return numberService.updateNumber(index, updatedNumber);
    }

    @DeleteMapping("number/{index}")
    public void deleteUser(@PathVariable Integer index) {
        numberService.deleteNumber(index);
    }

}
