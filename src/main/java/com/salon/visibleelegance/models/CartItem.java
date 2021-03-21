package com.salon.visibleelegance.models;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int quantity;

    @Column
    private double price;

    // relationships

    // many order items to one product
    @ManyToOne
    private Product product;

    // many order items to one order
    @ManyToOne
    private Cart cart;

    public CartItem(){}

    public CartItem(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public CartItem(long id, int quantity, double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
