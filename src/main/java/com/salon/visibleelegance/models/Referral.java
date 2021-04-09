package com.salon.visibleelegance.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "referrals")
public class Referral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    private User referrer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="friend_id")
    private User friend;

    public Referral(){}

    public Referral(User referrer, User friend) {
        this.referrer = referrer;
        this.friend = friend;
    }

    public Referral(long id, User referrer, User friend) {
        this.id = id;
        this.referrer = referrer;
        this.friend = friend;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getReferrer() {
        return referrer;
    }

    public void setReferrer(User referrer) {
        this.referrer = referrer;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
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
}
