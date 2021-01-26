package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.RoleDao;
import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UserAlreadyExitsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    RoleDao roleDao;

    @Autowired
    UsersDao usersDao;
    @Override
    public Users createUser(Users user) throws UserAlreadyExitsException{
        if (usersDao.findByEmailId(user.getEmailId()).isPresent()) {
            throw new UserAlreadyExitsException("Email Already Exists");
        }
        if (usersDao.findByMobileNumber(user.getMobileNumber()).isPresent()) {
            throw new UserAlreadyExitsException("Mobile Number Already Exists");
        }
        return usersDao.save(user);

    }

}
