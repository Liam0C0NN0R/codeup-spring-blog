package com.codeup.codeupspringblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codeup.codeupspringblog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
