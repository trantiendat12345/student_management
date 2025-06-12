package com.example.student.management.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.entity.Advisor;
import com.example.student.management.repository.AdvisorRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class AdivisorSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AdvisorRepository advisorRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        if (isTableEmpty()) {

            System.out.println("Advisor!");

            Advisor advisor = new Advisor();
            advisor.setStudentId(1L);
            advisor.setTeacherId(1L);
            advisorRepository.save(advisor);
            
        }

    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Advisor").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }

}
