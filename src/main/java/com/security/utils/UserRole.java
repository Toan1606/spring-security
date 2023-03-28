package com.security.utils;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.security.utils.UserPermission.*;

public enum UserRole {

    STUDENT(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, COURSE_READ)),
    ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE));

    private final Set<UserPermission> roles;

    UserRole(Set<UserPermission> roles) {
        this.roles = roles;
    }
}
