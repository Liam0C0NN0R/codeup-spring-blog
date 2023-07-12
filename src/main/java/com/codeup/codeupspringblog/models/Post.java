package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.NotEmpty;

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

    @NotEmpty(message = "Title cannot be empty")
    @Column(nullable = false, length = 100)
    private String title;

    @NotEmpty(message = "Body cannot be empty")
    @Column(length = 12222, nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
