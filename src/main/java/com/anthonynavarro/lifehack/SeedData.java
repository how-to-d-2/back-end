package com.anthonynavarro.lifehack;

import com.anthonynavarro.lifehack.models.Howtos;
import com.anthonynavarro.lifehack.models.Role;
import com.anthonynavarro.lifehack.models.User;
import com.anthonynavarro.lifehack.models.UserRoles;
//import com.anthonynavarro.lifehack.models.Useremail;
import com.anthonynavarro.lifehack.services.RoleService;
import com.anthonynavarro.lifehack.services.HowtoService;
import com.anthonynavarro.lifehack.services.UserService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Transactional
@Component
public class SeedData
        implements CommandLineRunner
{

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    HowtoService howtoService;


    @Transactional
    @Override
    public void run(String[] args) throws
            Exception {

        userService.deleteAll();
        roleService.deleteAll();

        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);




        User u1 = new User("admin", "password", "email-1@howto.local");
        u1 = userService.save(u1);
        u1.getHowtos()
                .add(new Howtos(u1,"How to cause a scene"));
        u1.getHowtos()
                .add(new Howtos(u1, "How to tie your shoe with a pencil"));
        Faker faker = new Faker();
//        List<User> userFakers = new ArrayList<>();
//        List<Howtos> howtoFakers = new ArrayList<>();


        User u2 = new User("Anthony", "password", "email-2@howto.local");
        u2 = userService.save(u2);
        u2.getHowtos()
                .add(new Howtos(u2,"How to boil water"));
        u2.getHowtos()
                .add(new Howtos(u2, "How to hack into any database"));



        User u3 = new User("Peep", "password", "email-3@howto.local");
        u3 = userService.save(u3);
        u3.getHowtos()
                .add(new Howtos(u3,"How to bbq with no grill"));
        u3.getHowtos()
                .add(new Howtos(u3,"How to defeat zelda"));


        User u4 = new User("Benjamin", "password", "email-4@howto.local");
        u4 = userService.save(u4);
        u4.getHowtos()

                .add(new Howtos(u4,"How to catch a fish with your bare hands"));
        u4.getHowtos()
                .add(new Howtos(u4,"How to fight off a bear with a roar"));


    }}

