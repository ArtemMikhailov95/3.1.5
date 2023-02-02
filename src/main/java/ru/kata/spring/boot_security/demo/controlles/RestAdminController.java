package ru.kata.spring.boot_security.demo.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/admin")
public class RestAdminController {
    UserServiceImpl userService;

    @Autowired
    public RestAdminController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> readAll() {
        List<User> userList = userService.readAll();
        return ResponseEntity.ok(userList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> read(@PathVariable("id") int id) {
        User user = userService.read(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.create(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") int id) {
        userService.update(user, id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
