package com.anthonynavarro.lifehack.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "howtos")
public class Howtos
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long howtoid;

    private String description;

    @ManyToOne
    @JoinColumn(name = "howtos",
            nullable = false)
    @JsonIgnoreProperties(value = "howtos",
            allowSetters = true)

    private User user;

    public Howtos() {
    }

    public Howtos(User user, String description)
    {
        this.description = description;
        this.user = user;
    }

    public long getHowtoid()
    {
        return howtoid;
    }

    public void setHowtoid(long howtoid)
    {
        this.howtoid = howtoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}