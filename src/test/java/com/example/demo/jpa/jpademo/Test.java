package com.example.demo.jpa.jpademo;


import com.example.demo.jpa.jpademo.entity.User;
import lombok.Data;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
//@ExtendWith(SpringExtension.class)
public class Test<Interface> {

    @PersistenceContext
    EntityManager em;

    @org.junit.Test
    @Ignore
    public void testing() {
        TypedQuery<com.example.demo.jpa.jpademo.entity.User> q = em.createQuery("select u  " +
                "from User u", com.example.demo.jpa.jpademo.entity.User.class);
        List<com.example.demo.jpa.jpademo.entity.User> c = q.getResultList();

        for (User user : c) {
            //System.out.println(comboI.getfName() + ""+comboI.getName());

        }
    }

    @org.junit.jupiter.api.Test
    public void testing2() {
        Query q = em.createQuery("select count(u.fName) " +
                "from User u");
        Object i = q.getSingleResult();

//            for (String user : c) {
//                System.out.println(user);
//
//            }


        System.out.println(i.toString());


    }

    @org.junit.jupiter.api.Test
    public void testing3() {
        Query q = em.createQuery("select u.fName, s.stockName  " +
                "from User u join u.usrStocks s ");
        List<Object> o = q.getResultList();


//            for (String user : c) {
//                System.out.println(user);
//
//            }


        System.out.println(o.toString());


    }

    @org.junit.jupiter.api.Test
    void fileReading() throws IOException {
        List<String> list = new ArrayList<>();
        Product p = new Product();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(("//Users//rajib//Downloads//jpademo///target//classes//file.txt")))) {
            List<String> parse = reader.lines()
                    .peek(x -> System.out.println("lines AFTER READING  "+x))
                    //.toString();
                    .collect(Collectors.toList());

            System.out.println("LINES   "+parse);
           // Stream<String> s = Pattern.compile("\\|").splitAsStream((parse.toString()));

           // System.out.println("LINES AFTER SPLIT   "+ Arrays.toString(s.toArray()));
            //Pattern.compile("\\|").splitAsStream((parse.toString()))
            Pattern.compile("\\|").splitAsStream(parse.toString())
                    .forEach(x ->

            {
                if (x.matches("^\\w+$")) {
                    p.setProdName(x);
                } else if ( x.matches("\\$\\d{2}\\.\\d{2}")) {
                    p.setDollaramt(x);
                } else if (x.matches("(\\(?\\^\\d{3}\\)?)-?(\\d{3})-?(\\d{4})")) {
                    p.setPhone(x);
                } else {
                    throw new RuntimeException(" Invalid line");
                }
            });
            System.out.println("these are good "+p.toString());
        }

        catch (Exception ex ){
            System.out.println(" "+ex.getMessage());

            //return;

        }


    }
}

    @Data
    class Product {

        String prodName = null;
        String dollaramt=null;
        String phone = null;

    }









