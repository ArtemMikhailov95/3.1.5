package ru.kata.spring.boot_security.demo.models;


import javax.persistence.*;
import java.util.Collection;

@Table(name = "users")
@Entity()
public class User {

    @Column
    private String username;

    @Column
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "last_name")
    private String last_name;

    @Column
    private int age;

    @Column
    private String email;

    public User() {
    }

    public User(String name, String last_name, int age, String email) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.email = email;
    }

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Roles> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return username;
    }

    public String roleName() {
        Roles[] role = roles.toArray(new Roles[getRoles().size()]);
        StringBuilder rolesList = new StringBuilder();
        for (Roles value : role) {
            rolesList.append(value);
        }
        return String.valueOf(rolesList);
    }
}