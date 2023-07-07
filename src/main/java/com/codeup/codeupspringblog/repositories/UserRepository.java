package com.codeup.codeupspringblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codeup.codeupspringblog.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByOrderByIdAsc();
}
