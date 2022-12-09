package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.models.Roles;

public interface RolesDAO extends JpaRepository<Roles, Integer> {
}