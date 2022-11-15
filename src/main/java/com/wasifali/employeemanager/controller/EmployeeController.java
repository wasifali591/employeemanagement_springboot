package com.wasifali.employeemanager.controller;


import com.wasifali.employeemanager.dto.common.APIResponseCount;
import com.wasifali.employeemanager.model.Employee;
import com.wasifali.employeemanager.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is a controller class Employees.
 * It processes the request and return the view as response.
 * @author Md Wasif Ali
 * @since 14/06/2022
 * @version 1.0
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ApiOperation(value = "Show All Employee",notes ="Show all employee list in JSON")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Successfully retrieved list")
    })


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees=employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // find all employee records with sorting
    @GetMapping("/all/{field}")
    public APIResponseCount<List<Employee>> getAllEmployeesWithSorting(@PathVariable String field){
        List<Employee> employees=employeeService.findAllEmployeesWithSorting(field);
        return new APIResponseCount<>(employees.size(), employees);
    }

    //find all employees with pagination
    @GetMapping("/all/pagination/{offset}/{pageSize}")
    public APIResponseCount<Page<Employee>> getAllEmployeesWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Employee> employees=employeeService.findAllEmployeesWithPagination(offset, pageSize);
        return new APIResponseCount<>(employees.getSize(), employees);
    }

    //find all employees with pagination and sorting
    @GetMapping("/all/pagination/{offset}/{pageSize}/{field}")
    public APIResponseCount<Page<Employee>> getAllEmployeesWithPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
        Page<Employee> employees=employeeService.findAllEmployeesWithPaginationAndSorting(offset, pageSize, field);
        return new APIResponseCount<>(employees.getSize(), employees);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getAllEmployeeById(@PathVariable("id") Long id){
        Employee employee=employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee=employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee=employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
