package com.anthonynavarro.lifehack.services;

import com.anthonynavarro.lifehack.LifehackApplication;
import com.anthonynavarro.lifehack.exceptions.ResourceNotFoundException;
import com.anthonynavarro.lifehack.models.Howtos;
import com.anthonynavarro.lifehack.models.Role;
import com.anthonynavarro.lifehack.models.User;
import com.anthonynavarro.lifehack.models.UserRoles;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LifehackApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HowtoServiceImplTest

{

@Autowired
 HowtoService howtoService;

@Autowired
UserService userService;


    @Before
    public void setUp() throws
            Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void TestFindAll()
    {
        assertEquals(6, howtoService.findAll().size());
    }


    @Transactional
    @WithUserDetails("test admin")
    @Test
    public void TestUpdate()
    {
        Role r2 = new Role("user");
        r2.setRoleid(2);

        User u2 = new User("hankHill", "password", "strickland@propane.com");
        u2.getRoles().add(new UserRoles(u2, r2));
        u2.getHowtos().add(new Howtos(u2, "new howto test"));

        User updatedu2 = userService.update(u2, 7);
    }

    @Test
    public void TestSave()
    {
        Role r2 = new Role("user");
        r2.setRoleid(2);

        User u2 = new User("bobby", "password", "Bhill@propane.com");
        u2.getRoles().add(new UserRoles(u2, r2));

        u2.getHowtos()
                .add(new Howtos(u2, "new howto test"));


        User updatedu2 = userService.update(u2, 7);

    }

    @Test
    public void TestDelete()
    {
        userService.delete(6);
        assertEquals(3, userService.findAll()
                .size());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void IdNotFoundDeleteTest()
    {
        userService.delete(100);
        assertEquals(4, userService.findAll()
                .size());
    }

    @Test
    public void FindByUsernameTest()
    {
        assertEquals("test admin", userService.findByName("test admin")
                .getUsername());
    }

}