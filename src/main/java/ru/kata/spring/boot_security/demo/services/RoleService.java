package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.Roles;

import java.util.List;

public interface RoleService {

    List<Roles> allRoles();

    Roles getRoleByName(String name);

    List<Roles> getRoleByNames(String[] names);

}
