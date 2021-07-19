package com.example.demo.jpa.jpademo.entity;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Data
public class Stock {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    int id;
    public String stockName;
    public String stockSymbol;
    public int stkQty;

    @ManyToOne
    @JoinColumn(columnDefinition = "fk", referencedColumnName = "id" )
    public User usr;
}
