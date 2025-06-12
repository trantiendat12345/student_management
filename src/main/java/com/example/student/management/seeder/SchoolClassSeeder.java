package com.example.student.management.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.entity.SchoolClass;
import com.example.student.management.repository.SchoolClassRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class SchoolClassSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Override
    public void run(String... args) throws Exception {

        if (isTableEmpty()) {

            System.out.println("SchoolClass!");

            SchoolClass dcctct66_09e = new SchoolClass();
            dcctct66_09e.setMajorId(1L);
            dcctct66_09e.setClassName("DCCTCT66_09E");
            dcctct66_09e.setAcademicYear("66");
            schoolClassRepository.save(dcctct66_09e);
            
        }
        
    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM SchoolClass").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }
    
}
