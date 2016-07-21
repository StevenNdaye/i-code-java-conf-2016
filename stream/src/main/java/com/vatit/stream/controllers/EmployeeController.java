package com.vatit.stream.controllers;

import com.vatit.stream.entities.Employee;
import com.vatit.stream.entities.Gender;
import com.vatit.stream.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Stream<Employee> getEmployees() {
        return employeeRepository.streamAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/by")
    public Stream<Employee> getEmployeesByGender(@RequestParam Gender gender) {
        return employeeRepository.findAllByGenderOrderByBirthDateDesc(gender);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter")
    public Stream<Employee> filterEmployees(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date bornFrom,
                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date bornTo) {
        Stream<Employee> employees = employeeRepository.streamAll().filter(
                d -> d.getBirthDate().after(bornFrom)
                        &&
                        d.getBirthDate().before(bornTo));
        return employees;
    }
}
