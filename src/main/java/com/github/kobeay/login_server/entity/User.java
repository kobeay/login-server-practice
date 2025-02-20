package com.github.kobeay.login_server.entity;

import com.github.kobeay.login_server.constant.EntityStatus;
import com.github.kobeay.login_server.constant.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "users")
@NoArgsConstructor
public class User extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "userID"))
    @Enumerated(EnumType.STRING)
    private List<Role> roles = new ArrayList<>();

    public User(String username, String password, EntityStatus status) {
        this. username = username;
        this.password = password;
        roles.add(Role.USER);

        this.setEntityStatus(status);
    }

    public void updatedRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void delete() {
        this.setEntityStatus(EntityStatus.DELETED);
    }
}
