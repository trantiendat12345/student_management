package com.example.student.management.seeder;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.entity.Teacher;
import com.example.student.management.repository.TeacherRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class TeacherSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void run(String... args) throws Exception {

        if (isTableEmpty()) {

            System.out.println("Teacher!");

            Teacher teacher = new Teacher();
            teacher.setMajorId(1L);
            teacher.setFullName("TTT");
            teacher.setGender("Female");
            teacher.setDateOfBirth(LocalDate.of(1888, 10, 9));
            teacher.setEmail("abcxyz@gmail.com");
            teacher.setNationalId("1234567899");
            teacher.setPhone("12345678909");
            teacher.setAddress("abcdefgh");
            teacher.setStatus("Active");
            teacherRepository.save(teacher);
            
        }
        
    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Teacher").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }
    
}
