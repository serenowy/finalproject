package com.example.finalproject.Controller;

import com.example.finalproject.Dto.Api;
import com.example.finalproject.Model.Employee;
import com.example.finalproject.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RequestMapping("/api/emp")
@RestController
public class EmployeeController {
    private final EmployeeService eservice;

    @GetMapping("/get")
    public ResponseEntity getE(){
        List<Employee> e= eservice.gete();
        return ResponseEntity.status(200).body(e);
    }
    @PostMapping("/add")
    public ResponseEntity addE(@RequestBody @Valid Employee emp){

        eservice.adde(emp);
        return ResponseEntity.status(200).body (new Api("Add Employee"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateE(@PathVariable Integer id, @Valid @RequestBody Employee e){

        eservice.updateE(id,e);

        return ResponseEntity.status(200).body(new Api(" employee Updated"));

    }
    @DeleteMapping("/delete/{id}")
    public String deleteE (@PathVariable Integer id){
        eservice.deleteE(id);
        return "employee DELETED";}

    @GetMapping("/byid/{id}")
    public ResponseEntity  getProByCode(@PathVariable Integer id )
    {
        Employee emp= eservice.getEmployeeById(id);
        return ResponseEntity.status(200).body(emp);
    }
    @GetMapping("/getup/{un}/{p}")
    public ResponseEntity getEmployeeByUsernameAndPassword(@PathVariable String  un  , @PathVariable Integer p )
    {
       Employee emp=eservice.getEmployeeByUsernameAndPassword(un,p);
        return ResponseEntity.status(200).body(emp);
    }
}
