package com.salon.visibleelegance.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="provided_services")
public class ProvidedService {
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

    public ProvidedService(){}

    // setter
    public ProvidedService(double price){
        this.price = price;
    }

    public ProvidedService(long id, double price) {
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

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
