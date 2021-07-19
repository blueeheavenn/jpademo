package com.example.demo.jpa.jpademo.dto;

import lombok.Data;

@Data
public class Stock {
    public String stockName;
    public String stockSymbol;
    public int stkQty;
}
