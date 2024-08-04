package com.keyin.dsa.user;

import com.keyin.dsa.numbers.Numbers;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @SequenceGenerator(name = "numbers_sequence", sequenceName = "numbers_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "numbers_sequence")
    private long userId;
    private String userName;
    private String password;

    @OneToMany
    private List<Numbers> numbers;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Numbers> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Numbers> numbers) {
        this.numbers = numbers;
    }
}
