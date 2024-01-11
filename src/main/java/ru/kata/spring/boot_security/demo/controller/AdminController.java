package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller("admin")
public class AdminController {
    private final UserService userService;
    private final String SUCCESS = "redirect:/admin";

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "cars";
    }

    @GetMapping("/admin/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @GetMapping(value = "/admin/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping(value = "/save")
    public String addUser(@RequestParam String username,
                          @RequestParam String surname,
                          @RequestParam String password,
                          @RequestParam String[] roles) {
        User user = new User(username, surname, password);
        userService.add(user);
        userService.addRoleToUser(roles, user);

        return SUCCESS;
    }

    @PostMapping("/admin/edit/{id}")
    public String updateUser(@RequestParam Long id,
                             @RequestParam String username,
                             @RequestParam String surname,
                             @RequestParam String password,
                             @RequestParam String[] roles) {
        User user = userService.findById(id);

        if (user != null) {
            userService.deleteRoleToUser(user);
            user.setUsername(username);
            user.setSurname(surname);
            user.setPassword(password);
            userService.update(user);
            userService.addRoleToUser(roles, user);
        }
        return SUCCESS;
    }

    @PostMapping(value = "/admin/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return SUCCESS;
    }
}
