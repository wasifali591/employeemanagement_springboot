package com.wasifali.employeemanager.service;

import com.wasifali.employeemanager.exception.UserNotFoundException;
import com.wasifali.employeemanager.model.Employee;
import com.wasifali.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return  employeeRepo.findAll();
    }
// Find ALl Employees with Sorting
    public List<Employee> findAllEmployeesWithSorting(String field){
        return  employeeRepo.findAll(Sort.by(field));
    }

    //Find all employees with pagination
    public Page<Employee> findAllEmployeesWithPagination(int offset, int pageSize){
        Page<Employee> employees = employeeRepo.findAll(PageRequest.of(offset, pageSize));
        return  employees;
    }
    //Find all employees with pagination and sorting
    public Page<Employee> findAllEmployeesWithPaginationAndSorting(int offset, int pageSize, String field){
        Page<Employee> employees = employeeRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  employees;
    }


    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by ID " + id + "was not found!"));
    }
}
