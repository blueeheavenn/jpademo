package com.example.demo.jpa.jpademo.dto;


import lombok.Data;

@Data
public class User {
    public String fName;
    public String lName;
    public int age;



    public User() {
    }

    public User(com.example.demo.jpa.jpademo.entity.User entity){
        this.fName=entity.getFName();
        this.lName=entity.getFName();
        this.age=entity.getAge();

    }


    public String getFName() {
        return this.fName;
    }

    public String getLName() {
        return this.lName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

}
