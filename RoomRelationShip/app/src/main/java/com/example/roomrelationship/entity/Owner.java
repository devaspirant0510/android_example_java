package com.example.roomrelationship.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Owner {
    @PrimaryKey(autoGenerate = false)
    public int ownerId;

    public String name;

    public void init(String name) {
        this.name = name;
    }
}
