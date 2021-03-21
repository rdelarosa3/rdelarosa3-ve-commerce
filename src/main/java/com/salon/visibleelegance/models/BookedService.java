package com.salon.visibleelegance.models;

import javax.persistence.*;

@Entity
@Table(name="booked_services")
public class BookedService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double price;

    // relationships

    // many to one appointment
    @ManyToOne
    private Appointment appointment;
    // many to one one service
    @ManyToOne
    private Service service;

    public BookedService(){}

    // setter
    public BookedService(double price){
        this.price = price;
    }

    // getter
    public BookedService(long id, double price){
        this.id = id;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
