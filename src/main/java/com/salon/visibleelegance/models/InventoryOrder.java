package com.salon.visibleelegance.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="inventory_orders")
public class InventoryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double cost;

    @Column
    private boolean isReceived;

    // many orders to one supplier
    @ManyToOne
    private Supplier supplier;

    // one order to many order items
    @OneToMany(mappedBy = "inventoryOrder")
    private Set<InventoryOrderItem> inventoryOrderItems = new HashSet<>();

    public InventoryOrder(){}

    // setter
    public InventoryOrder(double cost) {
        this.cost = cost;
    }

    // getter
    public InventoryOrder(long id, double cost, boolean isReceived) {
        this.cost = cost;
        this.id = id;
        this.isReceived = isReceived;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<InventoryOrderItem> getInventoryOrderItems() {
        return inventoryOrderItems;
    }

    public void setInventoryOrderItems(Set<InventoryOrderItem> inventoryOrderItems) {
        this.inventoryOrderItems = inventoryOrderItems;
    }

    public boolean isReceived() {
        return isReceived;
    }

    public void setReceived(boolean received) {
        isReceived = received;
    }
}
