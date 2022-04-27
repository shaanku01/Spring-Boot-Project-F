package com.zemoso.springboot.thymeleafdemo.controller;


import com.zemoso.springboot.thymeleafdemo.entity.Employee;
import com.zemoso.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String home(){
        return "index";
    }




    @GetMapping("/employees")
    public String getEmployees(Model model){
        List<Employee> employees = employeeService.findAll();

        if(employees.size()>0){
            model.addAttribute("employees",employees);
            return "employees/employeeview";

        }else {
            return "employees/emptyview";
        }


    }

    @GetMapping("/employees/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);

        return "employees/employee-form";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "employees/employee-form";

    }

    @GetMapping("/employees/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id){

        employeeService.deleteEmployee(id);


        return "redirect:/employees";
    }



}
