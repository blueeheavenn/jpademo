package com.example.demo.jpa.jpademo.dto;


import java.sql.Timestamp;

//INTERFACE FOR QUERY RESULT PROJECTION
public interface ComboI {
     String getfName();
     String getName();
//    @Value("#{kola}")
//    String bola ;
    Timestamp getTime();

}
