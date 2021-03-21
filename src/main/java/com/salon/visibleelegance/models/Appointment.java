package com.salon.visibleelegance.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Date date;

    @Column
    private double total;

    @Column
    private double tax;

    @Column
    private double discount;

    @Column
    private double subTotal;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date updatedAt;

    // relationships

    // many to one client
    @ManyToOne
    private User client;

    // many to one client
    @ManyToOne
    private User stylist;

    // one to many booked services
    @OneToMany(mappedBy = "appointment")
    private Set<BookedService> bookedServices = new HashSet<>();

    // one to many provided services
    @OneToMany(mappedBy = "appointment")
    private Set<ProvidedService> providedServices = new HashSet<>();

    public Appointment(){}

    // setter
    public Appointment(Date date, double total, double tax, double discount, double subTotal) {
        this.date = date;
        this.total = total;
        this.tax = tax;
        this.discount = discount;
        this.subTotal = subTotal;
    }

    // getter
    public Appointment(long id, Date date, double total, double tax, double discount, double subTotal) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.tax = tax;
        this.discount = discount;
        this.subTotal = subTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getStylist() {
        return stylist;
    }

    public void setStylist(User stylist) {
        this.stylist = stylist;
    }

    public Set<BookedService> getBookedServices() {
        return bookedServices;
    }

    public void setBookedServices(Set<BookedService> bookedServices) {
        this.bookedServices = bookedServices;
    }

    public Set<ProvidedService> getProvidedServices() {
        return providedServices;
    }

    public void setProvidedServices(Set<ProvidedService> providedServices) {
        this.providedServices = providedServices;
    }
}
