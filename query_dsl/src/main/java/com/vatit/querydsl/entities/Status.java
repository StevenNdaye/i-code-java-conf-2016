package com.vatit.querydsl.entities;

public enum Status {
    ACTIVE(0), INACTIVE(1);

    private int status;

    Status(int status) {
        this.status = status;
    }
}
