package com.example.finalproject.Service;
import com.example.finalproject.Exception.ApiException;
import com.example.finalproject.Model.Employee;
import com.example.finalproject.Model.Product;
import com.example.finalproject.Repository.EmployeeRepository;
import com.example.finalproject.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository eRepository;

    public List<Employee> gete() {
        return eRepository.findAll();
    }
    public void adde(Employee e){
        eRepository.save(e);
    }
    public Employee updateE(Integer id,Employee e){
        Employee olde=eRepository.findEmployeeById(id);
        if(olde==null){
             throw new ApiException("wrong Id");}
        olde.setId(e.getId());
        olde.setName(e.getName());
        olde.setUsername(e.getUsername());
        olde.setPassword(e.getPassword());
        eRepository.save(olde);
        return olde;
    }
    public Employee deleteE(Integer id){
       Employee e=eRepository.findEmployeeById(id);
        if(e==null){
            throw new ApiException("wrong Id");

        }
        eRepository.delete(e);
        return e;
    }
    public Employee getEmployeeById(Integer id){
        Employee e =eRepository.findEmployeeById(id);
        if(e==null){throw new ApiException("wrong code");}
        return e;
    }
    public Employee getEmployeeByUsernameAndPassword(String un, Integer p ) {

      Employee emp =eRepository.findEmployeeByUsernameAndPassword(un,p);
        if(eRepository.findEmployeeByUsernameAndPassword(un,p)==null)
        {throw new ApiException("wrong username or password");}
        return emp;
    }

}
