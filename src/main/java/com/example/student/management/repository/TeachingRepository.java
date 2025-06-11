package com.example.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.management.entity.Teaching;

@Repository
public interface TeachingRepository extends JpaRepository<Teaching, Long> {
    
}
