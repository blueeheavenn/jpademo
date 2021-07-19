package com.example.demo.jpa.jpademo.repo;

import com.example.demo.jpa.jpademo.dto.ComboI;
import com.example.demo.jpa.jpademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import java.util.List;

@Repository
@Component
public interface UserRepo extends JpaRepository<User, Integer> {

    @PersistenceContext
    EntityManager em=null;

    @Query(value="select u.f_name as fname, u.l_name as name, u.age as age,  s.stock_Name as stkname, s.stock_Symbol as symbol, s.stk_Qty as qty    " +
            "from  user u inner join stock s on u.id=s.usr_id",
            nativeQuery = true)
    List<Tuple> getUsers(); //TUPLE EXAMPLE

//    @Query(value="select u.f_name as fname, u.l_name as name " +
//            "from  user u inner join stock s on u.id=s.usr_id",
//            nativeQuery = true)

//    @Query(value="select u.fName as fName, u.lName as name, CURRENT_TIMESTAMP as Time " +
//        "from User u  join u.usrStocks s")
//    List<ComboI> getUsers2(); //PROJECTION EXAMPLE

    @Query(value="select u.fName as fName, u.lName as name, CURRENT_TIMESTAMP as Time from User u ")
    List<ComboI> getUsers2(); //PROJECTION EXAMPLE




}
