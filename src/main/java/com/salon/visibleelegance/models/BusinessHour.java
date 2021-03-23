package com.salon.visibleelegance.models;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="business_hours")
public class BusinessHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Min(1)
    @Max(7)
    @Column
    private int day;

    @Column
    private boolean isClosed;

    @NotBlank
    @Column
    private String openTime;

    @NotBlank
    @Column
    private String closeTime;

    // relationships
    //  many to one business;
    @ManyToOne
    private Business business;


    public BusinessHour(){}

    public BusinessHour(int day, boolean isClosed, String openTime, String closeTime){
        this.day = day;
        this.isClosed = isClosed;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public BusinessHour(long id, int day, boolean isClosed, String openTime, String closeTime){
        this.day = day;
        this.isClosed = isClosed;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
