package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.HashSet;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        Role admRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");
        this.roleRepository.save(admRole);
        this.roleRepository.save(userRole);
        String encodedPassword1 = passwordEncoder.encode("admin");
        String encodedPassword2 = passwordEncoder.encode("user");


        User admin = new User("admin", "Admin", encodedPassword1);
        admin.setRoles(new HashSet<>(List.of(admRole, userRole)));

        User user = new User("user", "User", encodedPassword2);
        user.setRoles(new HashSet<>(List.of(userRole)));
        this.userRepository.save(admin);
        this.userRepository.save(user);
    }
}