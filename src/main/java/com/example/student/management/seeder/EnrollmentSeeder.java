package com.example.student.management.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.entity.Enrollment;
import com.example.student.management.repository.EnrollmentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class EnrollmentSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if (isTableEmpty()) {

            System.out.println("Enrollment!");

            Enrollment enrollment = new Enrollment();
            enrollment.setStudentId(1L);
            enrollment.setSubjectId(1L);
            enrollment.setTeacherId(1L);
            enrollment.setSemester("I");
            enrollment.setAcademicYear("2025-2026");
            enrollmentRepository.save(enrollment);
            
        }
        
    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Enrollment").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }
    
}
