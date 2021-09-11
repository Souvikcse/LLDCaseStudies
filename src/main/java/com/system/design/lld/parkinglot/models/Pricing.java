package com.system.design.lld.parkinglot.models;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.service.strategy.payment.PaymentStrategy;

import java.io.*;
import java.util.Date;

//TODO:: to be implemented
public class Pricing {
    private int id;
    private Date createdAt;
    private Double amount;

    public Pricing(int id, Double amount) {
        this.id = id;
        this.createdAt = new Date(System.currentTimeMillis());
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
