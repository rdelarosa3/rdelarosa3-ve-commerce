package com.salon.visibleelegance.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank(message = "Amount can't be empty")
    private int amount;

    @Column
    @NotBlank(message = "Price can't be empty")
    private double price;

    public Measurement(){}

    public Measurement(int amount, double price){
        this.amount = amount;
        this.price = price;
    }

    public Measurement(long id, int amount, double price){
        this.amount = amount;
        this.price = price;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
