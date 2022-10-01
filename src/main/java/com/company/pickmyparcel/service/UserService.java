package com.company.pickmyparcel.service;


import com.company.pickmyparcel.model.User;

public interface UserService {

    User registerUser(User user);

    User getUserByContactNumber(String contactNo);
}
