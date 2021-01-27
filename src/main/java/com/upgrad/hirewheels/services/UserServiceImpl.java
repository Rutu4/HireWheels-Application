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
        if (usersDao.findByEmailId(user.getEmailId()).isPresent()) {
            throw new UserAlreadyExitsException("Email Already Exists");
        }
        if (usersDao.findByMobileNumber(user.getMobileNumber()).isPresent()) {
            throw new UserAlreadyExitsException("Mobile Number Already Exists");
        }
        return usersDao.save(user);

    }

    @Override
    public Users getUser(String emailId, String password) throws UserAlreadyExitsException{
        if(usersDao.findByEmailId(emailId).isPresent()){
            if(usersDao.findByEmailId(emailId).getPassword()==password){
                return usersDao.findByEmailId(emailId);
            }else {
                throw new UserAlreadyExitsException("Unauthorized User");
            }
        }else {
            throw new UserAlreadyExitsException("User not Registered");
        }
        return usersDao.findByEmailId(emailId);
    }

}
