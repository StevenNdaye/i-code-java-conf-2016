package com.vatit.specification.repository;

import com.vatit.specification.entities.Employee;
import com.vatit.specification.entities.Gender;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

    List<Employee> findByGender(Gender gender, Specifications<Employee> specs, Sort byBirthDate);

    class Specs {
        public static Specification<Employee> firstNameIs(String firstName) {
            return (root, query, cb) -> cb.like(root.get("firstName"), firstName);
        }

        public static Specification<Employee> lastNameIs(String lastName) {
            return (root, query, cb) -> cb.like(root.get("lastName"), lastName);
        }

        public static Specification<Employee> birthDateIsBetween(Date from, Date to) {
            return (root, query, cb) -> cb.between(root.get("birthDate"), from, to);
        }

        public static Specification<Employee> birthDateIsBefore(Date limit) {
            return (root, query, cb) -> cb.lessThan(root.get("birthDate"), limit);
        }

        public static Specification<Employee> birthDateIsAfter(Date limit) {
            return (root, query, cb) -> cb.greaterThan(root.get("birthDate"), limit);
        }

        public static Sort orderByHireDateDesc() {
            return new Sort(Sort.Direction.ASC, "hireDate");
        }

        public static Sort orderByBirthDateAsc() {
            return new Sort(Sort.Direction.ASC, "hireDate");
        }

        public static Specification<Employee> hireDateIsBetween(Date from, Date to) {
            return (root, query, cb) -> cb.between(root.get("hireDate"), from, to);
        }

        public static Specification<Employee> hireDateIsBefore(Date limit) {
            return (root, query, cb) -> cb.lessThan(root.get("hireDate"), limit);
        }

        public static Specification<Employee> hireDateIsAfter(Date limit) {
            return (root, query, cb) -> cb.greaterThan(root.get("hireDate"), limit);
        }
    }
}
