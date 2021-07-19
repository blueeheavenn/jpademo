package com.example.demo.jpa.jpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Component
public class Combo {
    public String fName;
    public String lName;
    public int age;
    public String stockName;
    public String stockSymbol;
    public int stkQty;

}
