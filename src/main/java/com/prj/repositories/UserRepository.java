package com.prj.repositories;

import com.prj.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Bạn có thể thêm các phương thức tìm kiếm tùy chỉnh tại đây, ví dụ:
    User findByUsername(String username);
}



