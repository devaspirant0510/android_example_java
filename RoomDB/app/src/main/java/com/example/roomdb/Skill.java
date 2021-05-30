package com.example.roomdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Skill {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String language;
    public String framework;
}
