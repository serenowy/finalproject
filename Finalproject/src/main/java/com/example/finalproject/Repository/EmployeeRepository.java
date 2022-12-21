package com.example.finalproject.Repository;

import com.example.finalproject.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
   Employee findEmployeeById( Integer id);
   Employee findEmployeeByUsernameAndPassword(String username  , Integer password );
}
