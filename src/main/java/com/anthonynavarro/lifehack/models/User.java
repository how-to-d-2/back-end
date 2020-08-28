package com.anthonynavarro.lifehack.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.*;


@Entity
@Table(name = "users")
public class User
        extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;


    @Column(nullable = false,
            unique = true)
    private String username;


    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    @Column(nullable = false,
            unique = true)

    @Email
    private String primaryemail;


    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "user",
            allowSetters = true)
    private List<UserRoles> roles = new ArrayList<>();


    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "user",
            allowSetters = true)
    private List<Howtos> howtos = new ArrayList<>();

    public User()
    {
    }

    public User(
            String username,
            String password,
            String primaryemail)
    {
        setUsername(username);
        setPassword(password);
        this.primaryemail = primaryemail;
    }

    public long getUserid()
    {
        return userid;
    }


    public void setUserid(long userid)
    {
        this.userid = userid;
    }


    public String getUsername()
    {
        return username;
    }


    public void setUsername(String username)
    {
        this.username = username.toLowerCase();
    }


    public String getPrimaryemail()
    {
        return primaryemail;
    }


    public void setPrimaryemail(String primaryemail)
    {
        this.primaryemail = primaryemail.toLowerCase();
    }


    public String getPassword()
    {
        return password;
    }


    public void setPasswordNoEncrypt(String password)
    {
        this.password = password;
    }


    public void setPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }


    public List<UserRoles> getRoles()
    {
        return roles;
    }

    public void setRoles(List<UserRoles> roles)
    {
        this.roles = roles;
    }

    public List<Howtos> getHowtos()
    {
        return howtos;
    }
    public void setHowtos(List<Howtos> howtos)
    {
        this.howtos = howtos;
    }


    @JsonIgnore
    public List<SimpleGrantedAuthority> getAuthority()
    {
        List<SimpleGrantedAuthority> rtnList = new ArrayList<>();

        for (UserRoles r : this.roles)
        {
            String myRole = "ROLE_" + r.getRole()
                    .getName()
                    .toUpperCase();
            rtnList.add(new SimpleGrantedAuthority(myRole));
        }

        return rtnList;
    }
}