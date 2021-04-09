package com.salon.visibleelegance.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int satisfaction;

    @Column
    private int recommendation;

    @Column
    private String experience;

    @Column
    private String improvement;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date updatedAt;

    // relationships

    // many reviews to one reviewer
    @ManyToOne
    private User reviewer;

    // one review to one appointment
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="appointment_id")
    private Appointment appointment;

    public Review(){}

    public Review(int satisfaction, int recommendation, String experience, String improvement, User reviewer, Appointment appointment) {
        this.satisfaction = satisfaction;
        this.recommendation = recommendation;
        this.experience = experience;
        this.improvement = improvement;
        this.reviewer = reviewer;
        this.appointment = appointment;
    }

    public Review(long id, int satisfaction, int recommendation, String experience, String improvement, User reviewer, Appointment appointment) {
        this.id = id;
        this.satisfaction = satisfaction;
        this.recommendation = recommendation;
        this.experience = experience;
        this.improvement = improvement;
        this.reviewer = reviewer;
        this.appointment = appointment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(int recommendation) {
        this.recommendation = recommendation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getImprovement() {
        return improvement;
    }

    public void setImprovement(String improvement) {
        this.improvement = improvement;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
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
