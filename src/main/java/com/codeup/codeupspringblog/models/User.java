package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Defaulting to no authorities/roles
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Defaulting to account never expires
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Defaulting to account is never locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Defaulting to credentials never expire
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Defaulting to account is always enabled
        return true;
    }
}
