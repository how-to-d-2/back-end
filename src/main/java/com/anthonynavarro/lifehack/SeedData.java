package com.anthonynavarro.lifehack;

import com.anthonynavarro.lifehack.models.Howtos;
import com.anthonynavarro.lifehack.models.Role;
import com.anthonynavarro.lifehack.models.User;
import com.anthonynavarro.lifehack.models.UserRoles;
import com.anthonynavarro.lifehack.models.Useremail;
import com.anthonynavarro.lifehack.services.RoleService;
import com.anthonynavarro.lifehack.services.HowtoService;
import com.anthonynavarro.lifehack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    HowtoService todoService;


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



        // admin, data, user
        User u1 = new User("admin", "password", "admin-email-1@howto.local");
        u1.getHowtos()
                .add(new Howtos(u1, "how to cause a scene"));
        u1.getHowtos()
                .add(new Howtos(u1, "How to tie your shoe with a pencil"));
        u1.getUseremails()
                .add(new Useremail(u1, "first-email@howto.local"));
        u1.getRoles()
                .add(new UserRoles(u1, r1));
        u1.getRoles()
                .add(new UserRoles(u1, r2));
        u1.getRoles()
                .add(new UserRoles(u1, r3));

        userService.save(u1);


        // data, user
        User u2 = new User("user2", "password", "admin-email-2@howto.local");

        u2.getHowtos()
                .add(new Howtos(u2,"how to boil water:"));


        // user
        User u3 = new User("user3", "password", "admin-email-3@howto.local");
        u3.getHowtos()
                .add(new Howtos(u3,"How to bbq with no grill"));
        u2.getRoles()
                .add(new UserRoles(u2, r2));
        userService.save(u2);
        u3.getRoles()
                .add(new UserRoles(u3, r2));
        userService.save(u3);


    }}