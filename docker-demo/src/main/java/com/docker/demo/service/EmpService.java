package com.docker.demo.service;

import com.docker.demo.model.Employee;
import com.docker.demo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    EmpRepository employeeRepository;

    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public Employee getEmpById(Long empId) {
        Optional<Employee> optionalEmp = employeeRepository.findById(empId);
        return optionalEmp.get();
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmp(Employee emp) {
        Employee existingEmp = employeeRepository.findById(emp.getId()).get();
        existingEmp.setFirstName(emp.getFirstName());
        existingEmp.setLastName(emp.getLastName());
        existingEmp.setEmail(emp.getEmail());
        Employee updatedUser = employeeRepository.save(existingEmp);
        return updatedUser;
    }


    public void deleteEmp(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
