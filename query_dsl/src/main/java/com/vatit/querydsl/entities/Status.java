package com.vatit.querydsl.entities;

public enum Status {
    ACTIVE(1), INACTIVE(0);

    private int status;

    Status(int status) {
        this.status = status;
    }
}
