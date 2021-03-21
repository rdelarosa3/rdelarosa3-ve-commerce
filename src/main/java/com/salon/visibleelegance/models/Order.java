package com.salon.visibleelegance.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "First name can't be empty")
    @Size(min = 2,message = "That name is too short")
    @Column(nullable = false, length = 250)
    private String name;

    @NotBlank(message = "Last name can't be empty")
    @Size(min = 2,message = "Last name is too short")
    @Column(nullable = false, length = 250)
    private String lastName;

    @NotBlank(message = "Address can't be empty")
    @Column(nullable = false, length = 250)
    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String zip;

    private String phoneNumber;

    private String email;

    private double total;

    private double tax;

    private double discount;

    private double subTotal;


    // relationships

    // many orders to one customer

    // one order to many order items


}
