package com.example.demo.jpa.jpademo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @GetMapping(path="/urls")
   // @ResponseStatus(HttpStatus.ACCEPTED)
    public Object getqueryS(){
        // Query q = em.createQuery("select u.fName, s.stockName , CURRENT_TIMESTAMP " +
        //      "from User u join u.usrStocks s ");
        //Object o=q.getResultList();
        return "TEST";


    }
}
