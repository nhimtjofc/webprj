package com.prj.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String password;
    private String email;
    private String fullName;
    private String phone;
    private String address;

    public User getUsername() {
        return null;
    }

    public Object getPassword() {
        return null;
    }

    public Object getEmail() {
        return null;
    }

    public Object getFullName() {
        return null;
    }

    public Object getPhone() {
        return null;
    }

    public Object getAddress() {
        return null;
    }

    public void setAddress(Object address) {
    }

    public void setPassword(Object password) {
    }

    public void setEmail(Object email) {
    }

    public void setFullName(Object fullName) {
    }

    public void setPhone(Object phone) {
    }

    public void setUsername(User username) {
    }
}
