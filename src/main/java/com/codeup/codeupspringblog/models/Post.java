package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 12222, nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
