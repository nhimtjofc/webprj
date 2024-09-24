package com.prj.controller;

import com.prj.entities.UserRole;
import com.prj.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    // Lấy tất cả các UserRole
    @GetMapping
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    // Tìm UserRole theo ID
    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable Long id) {
        UserRole userRole = userRoleService.getUserRoleById(id);
        if (userRole != null) {
            return ResponseEntity.ok(userRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Tạo UserRole mới
    @PostMapping
    public UserRole createUserRole(@RequestBody UserRole userRole) {
        return userRoleService.addUserRole(userRole);
    }

    // Cập nhật UserRole
    @PutMapping("/{id}")
    public ResponseEntity<UserRole> updateUserRole(@PathVariable Long id, @RequestBody UserRole userRoleDetails) {
        UserRole updatedUserRole = userRoleService.updateUserRole(id, userRoleDetails);
        if (updatedUserRole != null) {
            return ResponseEntity.ok(updatedUserRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa UserRole
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Long id) {
        userRoleService.deleteUserRole(id);
        return ResponseEntity.noContent().build();
    }
}
