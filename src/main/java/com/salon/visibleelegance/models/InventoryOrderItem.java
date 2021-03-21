package com.salon.visibleelegance.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="inventory_order_items")
public class InventoryOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column
    private int quantity;

    @NotBlank
    @Column
    private double supplyPrice;

    // relationships
    // many order items to one product
    @ManyToOne
    private Product product;

    // many order items to one order
    @ManyToOne
    private InventoryOrder inventoryOrder;

    public InventoryOrderItem(){}

    public InventoryOrderItem(int quantity, double supplyPrice){
        this.quantity = quantity;
        this.supplyPrice = supplyPrice;
    }

    public InventoryOrderItem(long id,int quantity, double supplyPrice){
        this.quantity = quantity;
        this.supplyPrice = supplyPrice;
        this.id = id;
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

    public double getSupplyPrice() {
        return supplyPrice;
    }

    public void setSupplyPrice(double supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public InventoryOrder getInventoryOrder() {
        return inventoryOrder;
    }

    public void setInventoryOrder(InventoryOrder inventoryOrder) {
        this.inventoryOrder = inventoryOrder;
    }
}
