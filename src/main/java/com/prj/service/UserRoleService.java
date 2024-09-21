package com.prj.service;

import com.prj.entities.UserRole;
import com.prj.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    // Lấy tất cả UserRole
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    // Tìm UserRole theo ID
    public UserRole getUserRoleById(Long id) {
        return userRoleRepository.findById(id).orElse(null);
    }

    // Tạo UserRole mới (gán user với role)
    public UserRole addUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    // Cập nhật UserRole
    public UserRole updateUserRole(Long id, UserRole userRoleDetails) {
        UserRole userRole = userRoleRepository.findById(id).orElse(null);
        if (userRole != null) {
            userRole.setUser(userRoleDetails.getUser());
            userRole.setRole(userRoleDetails.getRole());
            return userRoleRepository.save(userRole);
        }
        return null;
    }

    // Xóa UserRole theo ID
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }
}

