package org.example.newapp1.Repo;

import org.example.newapp1.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Query("SELECT emp FROM Employee emp WHERE emp.nom LIKE %:nom%")
    List<Employee> findByNomContains(@Param("nom") String nom);
}
