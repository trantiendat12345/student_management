package com.example.student.management.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.entity.Grade;
import com.example.student.management.repository.GradeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class GradeSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if (isTableEmpty()) {

            System.out.println("Grade!");

            Grade datMath = new Grade();
            datMath.setStudentId(1L);
            datMath.setSubjectId(1L);
            datMath.setMidtermScore(8.5f);
            datMath.setFinalScore(9.0f);
            datMath.setAverageScore(9.5f);
            gradeRepository.save(datMath);
            
        }
        
    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Grade").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }
    
}
