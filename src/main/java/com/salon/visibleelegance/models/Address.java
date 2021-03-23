package com.salon.visibleelegance.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Address can't be empty")
    @Column(nullable = false, length = 250)
    private String addressLine1;

    @Column(length = 250)
    private String addressLine2;

    @NotBlank(message = "City can't be empty")
    @Column(nullable = false, length = 250)
    private String city;

    @NotBlank(message = "State can't be empty")
    @Column(nullable = false, length = 250)
    private String state;

    @NotBlank(message = "Zip can't be empty")
    @Column(nullable = false, length = 25)
    private String zip;

    @Column(length = 50)
    private String phoneNumber;

    @Column
    private boolean isBilling;

    // relationships
//    many to one business
    @ManyToOne
    private Business business;
//    many to one user
    @ManyToOne
    private User user;

    public Address(){};

    // setter
    public Address(String addressLine1, String addressLine2, String city, String state, String zip, String phoneNumber, boolean isBilling){
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.isBilling = isBilling;
    }

    // getter
    public Address(int id, String addressLine1, String addressLine2, String city, String state, String zip, String phoneNumber, boolean isBilling){
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.isBilling = isBilling;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isBilling() {
        return isBilling;
    }

    public void setBilling(boolean billing) {
        isBilling = billing;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
