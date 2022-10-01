package com.company.pickmyparcel.service;


import com.company.pickmyparcel.model.User;
import com.company.pickmyparcel.model.UserRole;
import com.company.pickmyparcel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        Optional<User> dbUser = userRepository.findById(user.getContactNo());
        if (dbUser.isPresent()) {
            throw new RuntimeException("User already registered with this contact number");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(UserRole.USER);
            return userRepository.save(user);
        }
    }

    @Override
    public User getUserByContactNumber(String contactNo) {
        Optional<User> dbUser = userRepository.findById(contactNo);
        if (dbUser.isPresent()) {
            return dbUser.get();
        } else {
            throw new RuntimeException("User does not exist with contact number : " + contactNo);
        }
    }


}
