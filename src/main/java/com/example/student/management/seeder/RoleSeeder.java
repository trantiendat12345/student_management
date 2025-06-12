package com.example.student.management.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.entity.Role;
import com.example.student.management.repository.RoleRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class RoleSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RoleRepository roleRepository;
    
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        
        if (isTableEmpty()) {

            System.out.println("Role!");

            Role admin = new Role();
            admin.setId(1L);
            admin.setRoleName("ADMIN");
            roleRepository.save(admin);

            Role teacher = new Role();
            teacher.setId(2L);
            teacher.setRoleName("TEACHER");
            roleRepository.save(teacher);

            Role student = new Role();
            student.setId(3L);
            student.setRoleName("STUDENT");
            roleRepository.save(student);
            
        }
        
    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Role").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }
    
}
