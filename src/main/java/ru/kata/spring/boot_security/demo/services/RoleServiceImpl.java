package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RolesDAO;
import ru.kata.spring.boot_security.demo.models.Roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private RolesDAO rolesDAO;

    public RoleServiceImpl(RolesDAO rolesDAO) {
        this.rolesDAO = rolesDAO;
    }

    @Override
    public List<Roles> allRoles() {
        return rolesDAO.findAll();
    }

    @Override
    public Roles getRoleByName(String name) {
        Long id;
        for (Roles role : rolesDAO.findAll()) {
            if (role.getName() == name) {
                return role;
            }
        }
        return null;
    }

    @Override
    public List<Roles> getRoleByNames(String[] names) {
        List<Roles> roleList = new ArrayList<>();
        for (String name:names) {
            roleList.add(getRoleByName(name));
        }
        return roleList;
    }
}