package com.classpath.ems.service;

import com.classpath.ems.dao.EmployeeDAO;
import com.classpath.ems.exception.ResourceNotFoundException;
import com.classpath.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee saveEmployee(Employee employee){
        return this.employeeDAO.save(employee);
    }

    public List<Employee> fetchAllEmployees(){
        return this.employeeDAO.findAll();
    }

    public Employee findById(long empId){
        return this.employeeDAO.findById(empId).orElseThrow(RuntimeException::new);
    }

    public void deleteEmployee(long empId){
        Employee employee = this.employeeDAO.findById(empId).orElseThrow(ResourceNotFoundException::new);
        this.employeeDAO.delete(employee);
    }
}