package com.example.roomrelationship.entity;


import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.roomrelationship.entity.Address;


@Entity
public class User {
    @PrimaryKey
    public int userId;

    public String firstName;

    @Embedded
    public Address address;

}
