package com.example.demo.jpa.jpademo.service;

import com.example.demo.jpa.jpademo.repo.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Stock {

    @Autowired
    StockRepo stockRepo;

    public Optional<com.example.demo.jpa.jpademo.entity.Stock> getUserStock(){

        return stockRepo.findById(0);
    }


}
