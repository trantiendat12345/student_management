package com.example.student.management.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class SchoolClassSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {

        if (isTableEmpty()) {
            System.out.println("SchoolClass!");
        }
        
    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM SchoolClass").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }
    
}
