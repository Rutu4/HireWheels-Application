package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.RoleDao;
import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Role;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UserAlreadyExitsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class userServiceTest {
    @Mock
    UsersDao usersDao;

    @Mock
    RoleDao roleDao;


    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    public void setUpMockito(){
        //Mockito.when(roleDao.save(new
        // Role(1,"save test")).thenReturn(new Role(1,"save test")));
        Mockito.when(roleDao.findById(1)).thenReturn(new Role(1,"save test"));

        Mockito.when(usersDao.save(new Users(1,"save test","save test","save test",
                "save test","save test",10, new Role(1,"save test")))).thenReturn(new Users(1,"save test","save test","save test",
                "save test","save test",10,new Role(1,"save test")));

        Mockito.when(usersDao.save(new Users())).thenReturn(new Users(1,"save test","save test","save test",
                "save test","save test",10,new Role(1,"save test")));

        Mockito.when(usersDao.findById(1)).thenReturn(Optional.of(new Users(1,"save test","save test","save test",
                "save test1","save test1",10,new Role(1,"save"))));

        Mockito.when(usersDao.findByMobileNumber("save test1")).thenReturn(new Users(1,
                "save test","save test","save test",
                "save test1","save test1",10,new Role(1,"save test")));

        Mockito.when(usersDao.findByEmailId("save test1")).thenReturn(new Users(1,
                "save test","save test","save test",
                "save test1","save test1",10,new Role(1, "save test")));


    }

    @Test
    public void testCreateUser() throws UserAlreadyExitsException {
        Role role=new Role();
        role.setRoleName("save test");
        Users user= new Users();
        user.setFirstName("save test");
        user.setWalletMoney(10);
        user.setPassword("save test");
        user.setRole(role);
        user.setMobileNumber("save test");
        user.setEmailId("save test");
        user.setLastName("save test");

        Users savedUser= userService.createUser(user);
        System.out.println(savedUser);
        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getUserId() != 0);
        Assertions.assertEquals("save test", savedUser.getFirstName());
        Assertions.assertEquals("save test", savedUser.getLastName());
        Assertions.assertEquals("save test", savedUser.getPassword());
        Assertions.assertEquals("save test", savedUser.getEmailId());
        Assertions.assertEquals("save test", savedUser.getMobileNumber());
        Assertions.assertEquals(10, savedUser.getWalletMoney());
        Assertions.assertEquals("save test", savedUser.getRole().getRoleName());

    }
    @Test
    public void testGetUser() throws UserAlreadyExitsException {
        Users getUser= userService.getUser("save test1", "save test");

        Assertions.assertNotNull(getUser);
        Assertions.assertTrue(getUser.getUserId() != 0);
        Assertions.assertEquals("save test", getUser.getFirstName());
        Assertions.assertEquals("save test", getUser.getLastName());
        Assertions.assertEquals("save test", getUser.getPassword());
        Assertions.assertEquals("save test1", getUser.getEmailId());
        Assertions.assertEquals("save test1", getUser.getMobileNumber());
        Assertions.assertEquals(10, getUser.getWalletMoney());
        Assertions.assertEquals("save test", getUser.getRole().getRoleName());

    }


}
