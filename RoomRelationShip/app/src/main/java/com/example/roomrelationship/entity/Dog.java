package com.example.roomrelationship.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dog {
    @PrimaryKey(autoGenerate = false)
    public int dogId;
    public int  dogOwnerId;
    public String  name;
    public int cuteness;
    public int barkVolume;
    public int breed;

    public void init( int dogOwnerId, String name, int cuteness, int barkVolume, int breed){
        this.dogOwnerId = dogOwnerId;
        this.name = name;
        this.cuteness = cuteness;
        this.barkVolume = barkVolume;
        this.breed = breed;
    }
}
