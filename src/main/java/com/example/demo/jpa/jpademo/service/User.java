package com.example.demo.jpa.jpademo.service;

import com.example.demo.jpa.jpademo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User {
    @Autowired
    UserRepo userRepo;


    public com.example.demo.jpa.jpademo.dto.User getUserData(int id){
      return new com.example.demo.jpa.jpademo.dto.User(
              userRepo.findById(0).get());

    }
}
