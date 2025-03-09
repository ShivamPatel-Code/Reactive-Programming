package com.webflux.reactive_programming.repository;

import com.webflux.reactive_programming.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class EmployeeRepository {
    private final List<Employee> employeeList = new CopyOnWriteArrayList<>();

    public EmployeeRepository(){
        employeeList.add(new Employee(1L, "Shivam Patel", "Software Engineer"));
        employeeList.add(new Employee(2L, "Ryan Cohen", "Architect"));
    }

    public List<Employee> findAll(){
        return employeeList;
    }

    public Optional<Employee> findEmployeeById(Long id){
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();
    }

    public Employee saveEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
    }
}
