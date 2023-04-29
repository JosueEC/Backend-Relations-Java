package com.example.springjpaadvance.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_auth")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_auth_sequence",
            sequenceName = "user_auth_sequence",
            allocationSize = 1,
            initialValue = 999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_auth_sequence"
    )
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
}
