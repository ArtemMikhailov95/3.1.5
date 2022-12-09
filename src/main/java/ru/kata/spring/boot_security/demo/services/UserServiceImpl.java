package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void create(User user) {
        userDAO.save(user);
    }

    @Transactional
    @Override
    public User read(int id) {
        return userDAO.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<User> readAll() {
        return userDAO.findAll();
    }

    @Transactional
    @Override
    public void update(User user, int id) {
        User user1 = userDAO.findById(id).orElseThrow();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
        user1.setAge(user.getAge());
        userDAO.save(user1);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.deleteById(id);
    }

    @Transactional
    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
