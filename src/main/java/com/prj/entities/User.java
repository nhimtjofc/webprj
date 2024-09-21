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

public String getPassword() {
    return password;
}

public String getEmail() {
    return email;
}

public String getFullName() {
    return fullName;
}

public String getPhone() {
    return phone;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public void setPassword(String password) {
    this.password = password;
}

public void setEmail(String email) {
    this.email = email;
}

public void setFullName(String fullName) {
    this.fullName = fullName;
}

public void setPhone(String phone) {
    this.phone = phone;
}

}
