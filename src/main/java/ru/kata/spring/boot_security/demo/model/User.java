package ru.kata.spring.boot_security.demo.model;

import lombok.*;
import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "roles", nullable = false)
    private String roles;

    public User(String username, String surname, String password, String roles) {
        this.username = username;
        this.surname = surname;
        this.password = password;
        this.roles = roles;
    }
}