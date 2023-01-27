package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Roles;

import java.util.List;
import java.util.Set;

@Repository
public interface RolesDAO extends JpaRepository<Roles, Long> {
    @Override
    List<Roles> findAll();

}
