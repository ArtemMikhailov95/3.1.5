package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    @Lazy
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
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
        user1.setLast_name(user.getLast_name());
        user1.setAge(user.getAge());
        user.setEmail(user.getEmail());
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

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Transactional
    @Override
    public void update(String username, User newUserData) {
        User user = userDAO.findByUsername(username);
        user.setPassword(passwordEncoder.encode(newUserData.getPassword()));
        user.setName(newUserData.getName());
        user.setLast_name(newUserData.getLast_name());
        user.setEmail(newUserData.getEmail());
        user.setRoles(newUserData.getRoles());
        userDAO.save(user);
    }
}
