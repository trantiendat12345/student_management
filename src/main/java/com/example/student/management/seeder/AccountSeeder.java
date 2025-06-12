package com.example.student.management.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.student.management.entity.Account;
import com.example.student.management.repository.AccountRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class AccountSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {

        if(isTableEmpty()) {

            System.out.println("Account!");

            String passwordEncode = passwordEncoder.encode("password");

            Account accountAdmin = new Account();
            accountAdmin.setUsername("admin@gmail.com");
            accountAdmin.setPassword(passwordEncode);
            accountAdmin.setRoleId(1);
            accountRepository.save(accountAdmin);

            Account accountTeacher = new Account();
            accountTeacher.setUsername("teacher@gmail.com");
            accountTeacher.setPassword(passwordEncode);
            accountTeacher.setRoleId(2);
            accountTeacher.setTeacherId(1L);
            accountRepository.save(accountTeacher);

            Account accountStudent = new Account();
            accountStudent.setUsername("student@gmail.com");
            accountStudent.setPassword(passwordEncode);
            accountStudent.setRoleId(3);
            accountStudent.setStudentId(1L);
            accountRepository.save(accountStudent);
            
            System.out.println("password: " + passwordEncode);
        }

    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Account").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }
    
}
