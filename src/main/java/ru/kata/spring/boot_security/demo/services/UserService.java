package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    void create(User user);

    User read(int id);

    List<User> readAll();

    void update(User user, int id);

    void delete(int id);

    User findByUsername(String username);

    User findByEmail(String email);

    void update(String username, User newUserData);
}