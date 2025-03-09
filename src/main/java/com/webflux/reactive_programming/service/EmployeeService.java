package com.webflux.reactive_programming.service;

import com.webflux.reactive_programming.model.Employee;
import com.webflux.reactive_programming.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeRepository.findEmployeeById(id);
    }

    public Employee createEmployee(@PathVariable Employee employee){
        return employeeRepository.save(employee);
    }
}
