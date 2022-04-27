package com.zemoso.springboot.thymeleafdemo.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee emp = new Employee(1,"Shanker","Sai","gr.shankersai@zemosolabs.com");


    @Test
    void getId() {
        int expectedResult = 1;
        int actualResult = emp.getId();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void setId() {
        int expectedResult = 3;
        emp.setId(3);
        int actualResult = emp.getId();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void getFirstName() {
        String expectedResult = "Shanker";
        String actualResult = emp.getFirstName();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void setFirstName() {
        String expectedResult = "Kalyan";
        emp.setFirstName("Kalyan");
        String actualResult = emp.getFirstName();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void getLastName() {
        String expectedResult = "Sai";
        String actualResult = emp.getLastName();
        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    void setLastName() {
        String expectedResult = "CH";
        emp.setLastName("CH");
        String actualResult = emp.getLastName();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void getEmail() {
        String expectedResult = "gr.shankersai@zemosolabs.com";
        String actualResult = emp.getEmail();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void setEmail() {
        String expectedResult = "kalyan.ch@zemosolabs.com";
        emp.setEmail("kalyan.ch@zemosolabs.com");
        String actualResult = emp.getEmail();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testToString() {
        String expected = "Employee{" +
                "id=" + emp.id +
                ", firstName='" + emp.firstName + '\'' +
                ", lastName='" + emp.lastName + '\'' +
                ", email='" + emp.email + '\'' +
                '}';

        String actual = emp.toString();
        assertThat(actual).isEqualTo(expected);
    }
}