package com.example.demo.jpa.jpademo.controller;


import com.example.demo.jpa.jpademo.dto.Combo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class Controller {

    @PersistenceContext
    EntityManager em;

    @GetMapping("/url1")
    public List getquery(){
       // Query q = em.createQuery("select u.fName, s.stockName , CURRENT_TIMESTAMP " +
          //      "from User u join u.usrStocks s ");
        //Object o=q.getResultList();
        return Collections.EMPTY_LIST;


    }

//    @GetMapping("/urls")
//    public String getqueryS(){
//        // Query q = em.createQuery("select u.fName, s.stockName , CURRENT_TIMESTAMP " +
//        //      "from User u join u.usrStocks s ");
//        //Object o=q.getResultList();
//        return "TEST";
//
//
//    }


    @GetMapping("/url2")
    public List getquery2() throws JsonProcessingException {
        Query q = em.createQuery("select u.fName, s.stockName , CURRENT_TIMESTAMP " +
                "from User u left join u.usrStocks s" );
        log.info("time now{}", LocalDateTime.now());

        log.info("OBJECT VALUE {}, another OBJECT VALUE{} ",new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(new Combo()));

        //new ObjectMapper().writeValueAsString(q);
        //Object o=q.getResultList();
        return q.getResultList();

    }
}
