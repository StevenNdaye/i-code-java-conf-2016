package com.vatit.specification.controller;

import com.vatit.specification.entities.Employee;
import com.vatit.specification.entities.Gender;
import com.vatit.specification.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static com.vatit.specification.repository.EmployeeRepository.Specs.birthDateIsBefore;
import static com.vatit.specification.repository.EmployeeRepository.Specs.birthDateIsBetween;
import static com.vatit.specification.repository.EmployeeRepository.Specs.firstNameIs;
import static com.vatit.specification.repository.EmployeeRepository.Specs.hireDateIsAfter;
import static com.vatit.specification.repository.EmployeeRepository.Specs.hireDateIsBetween;
import static com.vatit.specification.repository.EmployeeRepository.Specs.lastNameIs;
import static com.vatit.specification.repository.EmployeeRepository.Specs.orderByBirthDateAsc;
import static com.vatit.specification.repository.EmployeeRepository.Specs.orderByHireDateDesc;
import static org.springframework.data.jpa.domain.Specifications.where;


@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{employeeNo}")
    public Employee getById(@PathVariable int employeeNo) {
        return employeeRepository.findOne(employeeNo);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/by")
    public List<Employee> filterByBirthDateAndHireDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date bornFrom,
                                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date bornTo,
                                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date hiredFrom,
                                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date hiredTo) {
        return employeeRepository.findAll(
                where(birthDateIsBetween(bornFrom, bornTo))
                        .and(hireDateIsBetween(hiredFrom, hiredTo))
        );
    }

    @RequestMapping(method = RequestMethod.GET, value = "/female")
    public List<Employee> filterByFemale(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date bornBefore) {
        return employeeRepository.findByGender(Gender.F,
                where(birthDateIsBefore(bornBefore)), orderByBirthDateAsc());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/male")
    public List<Employee> filterByMale(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date hiredAfter) {
        return employeeRepository.findByGender(Gender.M,
                where(hireDateIsAfter(hiredAfter)), orderByHireDateDesc());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employee")
    public List<Employee> getEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date bornBefore,
                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date hiredAfter) {
        return employeeRepository.findAll(
                where(firstNameIs(firstName))
                        .and(lastNameIs(lastName))
                        .and(birthDateIsBefore(bornBefore))
                        .and(hireDateIsAfter(hiredAfter))
                , orderByBirthDateAsc()
        );
    }


}
