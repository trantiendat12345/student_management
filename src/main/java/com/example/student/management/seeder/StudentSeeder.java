package com.example.student.management.seeder;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.entity.Student;
import com.example.student.management.repository.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class StudentSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;
    
    @Override
    public void run(String... args) throws Exception {

        if (isTableEmpty()) {

            System.out.println("Student!");

            Student dat = new Student();
            dat.setClassId(1L);
            dat.setFullName("Trần Tiến Đạt");
            dat.setGender("Male");
            dat.setDateOfBirth(LocalDate.of(2003, 10, 07));
            dat.setEmail("trantiendat@gmail.com");
            dat.setNationalId("123456789");
            dat.setPhone("0123456789");
            dat.setAddress("abcdxyz");
            dat.setAcademicYear("66");
            dat.setStatus("Enrolled");
            studentRepository.save(dat);
            
        }
        
    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Student").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }
    
}
