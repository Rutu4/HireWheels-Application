package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.RoleDao;
import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.BookingDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExitsException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    RoleDao roleDao;

    @Autowired
    UsersDao usersDao;

    @Override
    public Users getUserDetails(int id) throws UserDetailsNotFoundException {
        return usersDao.findById(id)
                .orElseThrow(
                        () -> new UserDetailsNotFoundException("Booking not found for id: " + id)
                );
    }
    @Override
    public Users createUser(Users user) throws UserAlreadyExitsException{
        if (usersDao.findByEmailId(user.getEmailId())!=null) {
            throw new UserAlreadyExitsException("Email Already Exists");
        }
        if (usersDao.findByMobileNumber(user.getMobileNumber())!=null) {
            throw new UserAlreadyExitsException("Mobile Number Already Exists");
        }

        Users user1=usersDao.save(user);
        System.out.println(user1);
        return user1;

    }

    @Override
    public Users getUser(String emailId, String password) throws UserAlreadyExitsException{
        if(usersDao.findByEmailId(emailId)!=null){
            if(usersDao.findByEmailId(emailId).getPassword().equals(password)){
                return usersDao.findByEmailId(emailId);
            }else {
                throw new UserAlreadyExitsException("Unauthorized User");
            }
        }else {
            throw new UserAlreadyExitsException("User not Registered");
        }

    }

}
