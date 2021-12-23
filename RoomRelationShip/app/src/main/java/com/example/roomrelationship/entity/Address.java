package com.example.roomrelationship.entity;

import androidx.room.ColumnInfo;

public class Address {
    public String street;
    public String state;
    public String city;
    @ColumnInfo(name = "post_code")
    public int postCode;
    public void init(String street,String state,String city,int postCode){
        this.street =street;
        this.state =state;
        this.city = city;
        this.postCode = postCode;
    }
}

