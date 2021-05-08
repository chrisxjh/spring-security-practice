package me.chrisxu.springsecuritypractice.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {
    STUDENT("STUDENT", new HashSet<>()),
    ADMIN("ADMIN", new HashSet<>(Arrays.asList(
            UserPermission.STUDENT_READ,
            UserPermission.STUDENT_WRITE,
            UserPermission.COURSE_READ,
            UserPermission.COURSE_WRITE
    ))),
    ADMIN_TRAINEE("ADMIN_TRAINEE", new HashSet<>(Arrays.asList(
            UserPermission.COURSE_READ,
            UserPermission.STUDENT_READ
    )));

    private final String string;
    private final Set<UserPermission> permissions;

    UserRole(String string, Set<UserPermission> permissions) {
        this.string = string;
        this.permissions = permissions;
    }

    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.toString()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority(String.format("ROLE_%s", string)));

        return authorities;
    }

    @Override
    public String toString() {
        return string;
    }
}
