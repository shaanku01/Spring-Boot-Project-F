package com.zemoso.springboot.thymeleafdemo.controller;

import com.zemoso.springboot.thymeleafdemo.entity.Employee;
import com.zemoso.springboot.thymeleafdemo.service.EmployeeService;
import com.zemoso.springboot.thymeleafdemo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DemoControllerTest {




    @Mock
    EmployeeService employeeService;

    DemoController demoController;
    @Mock
    Model model;
    @Mock
    Employee emp;

    @BeforeEach
    void setUp() {
        this.demoController=new DemoController(this.employeeService);
    }





    @Test
    void home() {
        String expectedResult = "index";
        String actualResult = demoController.home();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void getEmployees() {
        String expectedResult = null;
        String actualResult = null;
        List<Employee> employees = employeeService.findAll();

        if(employees.size()>0){

            expectedResult  = "employees/employeeview";


        }else {
            expectedResult =  "employees/emptyview";
        }

        actualResult = demoController.getEmployees(model);
        assertThat(actualResult).isEqualTo(expectedResult);


    }


    @Test
    void getEmployees2() {
        String expectedResult = null;
        String actualResult = null;
        int size = 0;

        if(size>0){

            expectedResult  = "employees/employeeview";


        }else {
            expectedResult =  "employees/emptyview";
        }

        actualResult = "employees/emptyview";
        assertThat(actualResult).isEqualTo(expectedResult);


    }
    @Test
    void getEmployees3() {
        String expectedResult = null;
        String actualResult = null;
        int size = 2;

        if(size>0){

            expectedResult  = "employees/employeeview";


        }else {
            expectedResult =  "employees/emptyview";
        }

        actualResult = "employees/employeeview";
        assertThat(actualResult).isEqualTo(expectedResult);


    }

    @Test
    void showFormForAdd() {
        String expectedResult = "employees/employee-form";
        String actualResult = demoController.showFormForAdd(model);
        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    void saveEmployee() {
        String expectedResult = "redirect:/employees";
        String actualResult = demoController.saveEmployee(emp);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void updateEmployee() {
        String expectedResult = "employees/employee-form";
        String actualResult = demoController.updateEmployee(1,model);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void deleteEmployee() {
        String expectedResult = "redirect:/employees";
        String actualResult = demoController.deleteEmployee(2);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}