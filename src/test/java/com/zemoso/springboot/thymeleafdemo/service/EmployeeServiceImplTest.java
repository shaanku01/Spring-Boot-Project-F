package com.zemoso.springboot.thymeleafdemo.service;

import com.zemoso.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.zemoso.springboot.thymeleafdemo.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;


    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        this.employeeService=new EmployeeServiceImpl(this.employeeRepository);
    }

    @Test
    void findAll() {
        employeeService.findAll();
        Mockito.verify(employeeRepository).findAllByOrderByLastNameAsc();
    }

    @Test
    void findById() {
        employeeService.findById(1);
        Mockito.verify(employeeRepository).findById(1);
    }

    @Test
    void saveEmployee() {
        Employee emp1 = new Employee();
        employeeService.saveEmployee(emp1);
        Mockito.verify(employeeRepository).save(emp1);
    }

    @Test
    void deleteEmployee() {
        employeeService.deleteEmployee(1);
        Mockito.verify(employeeRepository).deleteById(1);
    }
}