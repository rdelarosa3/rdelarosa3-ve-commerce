package com.salon.visibleelegance.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="socials")
public class Social {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name can't be empty")
    @Size(min = 2,message = "That name is too short")
    @Column
    private String name;

    @Column
    @Pattern(
            regexp = "^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$",
            message = "invalid url"
    )
    private String url;

    // relationships

    @ManyToOne
    private Business business;

    public Social(){}

    public Social(String name, String url){
        this.name = name;
        this.url = url;
    }

    public Social(long id,String name, String url){
        this.name = name;
        this.url = url;
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
