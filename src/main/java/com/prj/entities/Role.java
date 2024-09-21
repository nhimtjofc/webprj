package com.prj.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;

    public String getRoleName() {
        return null;
    }

    public void setRoleName(Object roleName) {
    }
}

