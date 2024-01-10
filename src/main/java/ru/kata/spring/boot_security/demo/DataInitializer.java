package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    password VARCHAR(255),\n" +
                "    username VARCHAR(255),\n" +
                "    surname VARCHAR(255),\n" +
                "    roles VARCHAR(255)\n" +
                ");");

        String encodedPassword1 = passwordEncoder.encode("test");

        jdbcTemplate.update("INSERT INTO users (password, username, surname, roles) VALUES (?, ?, ?, ?)",
                encodedPassword1, "user1", "surname1", "ROLE_ADMIN");

        jdbcTemplate.update("INSERT INTO users (password, username, surname, roles) VALUES (?, ?, ?, ?)",
                encodedPassword1, "user2", "surname2", "ROLE_USER");
    }
}