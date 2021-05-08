package me.chrisxu.springsecuritypractice.security;

public enum UserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String string;

    UserPermission(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
