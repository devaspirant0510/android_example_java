package com.example.roomdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NoteBook {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int ram;
    public String cpu;
    public String gpu;

}
