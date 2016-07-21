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
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeRepository.streamAll().collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/by")
    public List<Employee> getEmployeesByGender(@RequestParam Gender gender) {
        return employeeRepository.findAllByGenderOrderByBirthDateDesc(gender)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter")
    public List<Employee> filterEmployees(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date bornFrom,
                                          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date bornTo) {
        return employeeRepository.streamAll().filter(
                d -> d.getBirthDate().after(bornFrom)
                        &&
                        d.getBirthDate().before(bornTo))
                .collect(Collectors.toList());
    }
}
