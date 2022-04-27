package com.zemoso.springboot.thymeleafdemo.service;

import com.zemoso.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.zemoso.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    EmployeeRepository employeeRepository;




    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        }
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
