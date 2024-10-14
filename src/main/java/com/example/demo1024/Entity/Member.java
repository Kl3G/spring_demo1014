package com.example.demo1024.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Post> posts;

    public Member toEntity() {

        return new Member(null, password, email, name, new ArrayList<>());
    }
}
