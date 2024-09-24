package com.prj.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user_roles")
public class UserRole {

    // Getter và Setter cho userRoleId (nếu cần)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    // Getter và Setter cho user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Thay đổi từ public sang private để tuân thủ nguyên tắc đóng gói

    // Getter và Setter cho role
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }
}


