package com.salon.visibleelegance.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Service name can't be empty")
    @Size(min = 2,message = "That name is too short")
    @Column(nullable = false, length = 250)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "integer default 0")
    private int length;

    @Column
    private double cost;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date updatedAt;

    // relationships
    @ManyToOne
    private Category category;

    // one to many booked service
    @OneToMany(mappedBy = "service")
    private Set<BookedService> bookedServices = new HashSet<>();

    // one to many provided service
    @OneToMany(mappedBy = "service")
    private Set<ProvidedService> providedServices = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name="service_promotions",
            joinColumns=@JoinColumn(name="service_id"),
            inverseJoinColumns=@JoinColumn(name="promotion_id")
    )
    private Set<Promotion> promotions = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name="stylist_services",
            joinColumns=@JoinColumn(name="service_id"),
            inverseJoinColumns=@JoinColumn(name="user_id")
    )
    private Set<User> stylists = new HashSet<>();

    public Service(){}

    public Service(String name, String description, int length, double cost){
        this.name=name;
        this.description = description;
        this.length = length;
        this.cost = cost;
    }

    public Service(long id,String name, String description, int length, double cost){
        this.name=name;
        this.description = description;
        this.length = length;
        this.cost = cost;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Set<User> getStylists() {
        return stylists;
    }

    public void setStylists(Set<User> stylists) {
        this.stylists = stylists;
    }
}
