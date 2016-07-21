package com.vatit.stream.repository;

import com.vatit.stream.entities.Employee;
import com.vatit.stream.entities.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.stream.Stream;

import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @QueryHints(value = @QueryHint(name = HINT_FETCH_SIZE, value = "" + Integer.MIN_VALUE))
    @Query(value = "select e from Employee e")
    Stream<Employee> streamAll();


    Stream<Employee> findAllByGenderOrderByBirthDateDesc(Gender gender);
}
