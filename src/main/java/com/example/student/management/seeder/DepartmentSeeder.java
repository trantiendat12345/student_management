package com.example.student.management.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.entity.Department;
import com.example.student.management.repository.DepartmentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class DepartmentSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if (isTableEmpty()) {
            
            System.out.println("Department!");

            Department informartionTechnology = new Department();
            informartionTechnology.setDepartmentName("INFORMATION TECHNOLOGY");
            departmentRepository.save(informartionTechnology);

        }
        
    }

    private boolean isTableEmpty () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Department").getSingleResult();
        return count == 0; // bằng 0 thì true còn lại thì false.
    }
    
}
