package com.vatit.querydsl.repository.predicates;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.vatit.querydsl.entities.QCustomer;
import com.vatit.querydsl.entities.Status;

import java.util.Date;

public class CustomerPredicates {

    public static Predicate belongToStore(int storeId) {
        QCustomer qCustomer = QCustomer.customer;
        return qCustomer.storeId.eq(storeId);
    }

    public static Predicate active(Status status) {
        QCustomer qCustomer = QCustomer.customer;
        return qCustomer.active.eq(status.ordinal());
    }

    public static OrderSpecifier<Date> orderByCreateDate() {
        QCustomer qCustomer = QCustomer.customer;
        return qCustomer.createDate.desc();
    }
}
