package com.salon.visibleelegance.models;

import javax.persistence.*;

@Entity
@Table(name="referral_rewards")
public class ReferralReward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int referralAmount;

    @Column
    private boolean isActive;

    @Column
    private double discount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id")
    private User client;

    public ReferralReward(){}

    public ReferralReward(int referralAmount, boolean isActive, double discount, User client) {
        this.referralAmount = referralAmount;
        this.isActive = isActive;
        this.discount = discount;
        this.client = client;
    }

    public ReferralReward(long id, int referralAmount, boolean isActive, double discount, User client) {
        this.id = id;
        this.referralAmount = referralAmount;
        this.isActive = isActive;
        this.discount = discount;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getReferralAmount() {
        return referralAmount;
    }

    public void setReferralAmount(int referralAmount) {
        this.referralAmount = referralAmount;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
