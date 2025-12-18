package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.*;
@Emtity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser{
    @Id
    @GeneratedValue(startgey=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String email;
    private String password;
    private String role;
}