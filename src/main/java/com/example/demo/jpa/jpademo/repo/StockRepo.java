package com.example.demo.jpa.jpademo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<com.example.demo.jpa.jpademo.entity.Stock, Integer> {
}
