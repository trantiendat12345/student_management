package com.example.student.management.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.entity.Subject;
import com.example.student.management.repository.SubjectRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class SubjectSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @Override
    public void run(String... args) throws Exception {

        if (isTableEmpty()) {

            System.out.println("Subject!");

            Subject math = new Subject();
            math.setSubjectName("Toan");
            math.setCredit(3);
            subjectRepository.save(math);
            
        }
        
    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Subject").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }
    
}
