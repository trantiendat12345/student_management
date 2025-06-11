package com.example.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.management.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
