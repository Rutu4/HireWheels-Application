package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UserAlreadyExitsException;

public interface UserService {
    Users createUser(Users users) throws UserAlreadyExitsException;
}
