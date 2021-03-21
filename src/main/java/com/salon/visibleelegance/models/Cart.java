package com.salon.visibleelegance.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="carts")
public class Cart {
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

    @NotBlank(message = "Phone can't be empty")
    @Column(nullable = false, length = 50)
    private String phoneNumber;

    @Email(message = "Email can't be empty")
    @NotBlank(message = "Email can't be empty")
    @Pattern(
            regexp = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$",
            message = "Invalid Email"
    )
    @Column(nullable = false, length = 250)
    private String email;

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

    // many orders to one customer
    @ManyToOne
    private User user;

    // one order to many order items
    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    public Cart(){}

    //setter
    public Cart(
            String addressLine1, String addressLine2, String city,
            String state, String zip, String phoneNumber, String email,
            double total, double tax, double discount, double subTotal
    ) {
        this.name = name;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.total = total;
        this.tax = tax;
        this.discount = discount;
        this.subTotal = subTotal;
    }

    // getter
    public Cart(
            long id, String name, String lastName,
            String addressLine1, String addressLine2, String city,
            String state, String zip, String phoneNumber, String email,
            double total, double tax, double discount, double subTotal
    ) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
