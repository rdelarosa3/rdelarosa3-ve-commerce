package com.salon.visibleelegance.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name="businesses")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Business name can't be empty")
    @Size(min = 2,message = "That name is too short")
    @Column(nullable = false)
    private String name;

    @Email
    @Pattern(
            regexp = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$",
            message = "Invalid Email"
    )
    @Column
    private String email;

    @NotBlank(message = "Phone number can't be empty")
    @Size(min = 10,message = "That number is too short")
    @Column
    private String phone;

    @Column
    @Pattern(
            regexp = "^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$",
            message = "invalid address"
    )
    private String website;

    @Column
    private String logo;

    @NotBlank(message = "O name can't be empty")
    @Size(min = 2,message = "That name is too short")
    @Column
    private String operator;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date updatedAt;

    // relationships
    @OneToMany(mappedBy = "business")
    private Set<Social> socials = new HashSet<>();

    @OneToMany(mappedBy = "business")
    private List<BusinessHour> businessHours = new ArrayList<>();

    @OneToMany(mappedBy = "business")
    private Set<Address> addressess = new HashSet<>();

    public Business(){}

    public Business(String name, String email, String phone, String logo, String operator, String website) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.logo = logo;
        this.operator = operator;
        this.website = website;
    }

    public Business(long id, String name, String email, String phone, String logo, String operator, String website) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.logo = logo;
        this.operator = operator;
        this.website = website;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Set<Social> getSocials() {
        return socials;
    }

    public void setSocials(Set<Social> socials) {
        this.socials = socials;
    }

    public List<BusinessHour> getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(List<BusinessHour> businessHours) {
        this.businessHours = businessHours;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Set<Address> getAddressess() {
        return addressess;
    }

    public void setAddressess(Set<Address> addressess) {
        this.addressess = addressess;
    }
}
