package com.example.demo.jpa.jpademo.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class User {
        @Id
        @GeneratedValue
        int id;
        public String fName;
        public String lName;
        public int age;

        @CreationTimestamp()
        @Temporal(TemporalType.TIMESTAMP)
        public Date Time;

        @OneToMany(fetch=FetchType.EAGER, mappedBy = "usr")
        //@JoinColumn(columnDefinition ="fk_id" ,   referencedColumnName ="id" )
        List<Stock> usrStocks;
}
