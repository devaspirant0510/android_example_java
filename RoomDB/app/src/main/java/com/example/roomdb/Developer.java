package com.example.roomdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Developer {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String gpu;
    public String cpu;
    public int ram;
    public String language;
    public String framework;
}
