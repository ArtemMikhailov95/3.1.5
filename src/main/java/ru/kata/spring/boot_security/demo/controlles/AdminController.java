package ru.kata.spring.boot_security.demo.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping()
    public String readAll(Principal principal, Model model) {
        // все юзеры

        model.addAttribute("createUser", new User());
        List<User> allUsers = userService.readAll();
        model.addAttribute("allUsers", allUsers);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("allRoles", roleService.allRoles()); // добавлен список всех ролей
        return "admin";
    }

    @GetMapping("/new")
    public String newUser(Principal principal, Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", roleService.allRoles());
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "addUser";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.create(user);

        return "redirect:/admin";
    }

//delete user

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user,
                         @PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    //edit user
    @GetMapping("/{username}/edit")
    public String edit(Model model, @PathVariable("username") String username) {
        model.addAttribute("user", userService.findByUsername(username));
        model.addAttribute("roles", roleService.allRoles());
        return "editUser";
    }

    @PatchMapping("/{username}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("username") String username) {
        userService.update(username, user);
        return "redirect:/admin/";
    }
}
