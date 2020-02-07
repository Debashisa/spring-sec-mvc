package com.deba.springsecurity.springsecuritymvc.repository;

import com.deba.springsecurity.springsecuritymvc.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {

    Role findByRole(String role);
}
