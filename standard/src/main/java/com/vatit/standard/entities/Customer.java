package com.vatit.standard.entities;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Customer {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;

    private Date birthDate;
    private Date enrollment;
    @Enumerated
    private FinancialStatus status;

    public Customer(Integer id, String firstName, String lastName, Date birthDate, Date enrollment, FinancialStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.enrollment = enrollment;
        this.status = status;
    }

    public Customer() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Date enrollment) {
        this.enrollment = enrollment;
    }

    public FinancialStatus getStatus() {
        return status;
    }

    public void setStatus(FinancialStatus status) {
        this.status = status;
    }
}
