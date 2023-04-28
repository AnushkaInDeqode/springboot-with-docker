package com.docker.demo.controller;

import com.docker.demo.model.Employee;
import com.docker.demo.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/emp")
public class EmpController {

    @Autowired
    private EmpService empService;


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
        Employee savedUser = empService.createEmployee(emp);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") Long empId){
        Employee user = empService.getEmpById(empId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllUsers(){
        List<Employee> emp = empService.getAllEmployees();
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody Employee emp){
        empService.getEmpById(userId);
        Employee updatedEmp = empService.updateEmp(emp);
        return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        empService.deleteEmp(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}