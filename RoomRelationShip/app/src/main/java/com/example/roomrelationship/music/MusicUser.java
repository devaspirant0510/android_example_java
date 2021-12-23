package com.example.roomrelationship.music;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MusicUser {
    @PrimaryKey
    public long userId;

    public String name;

    public int age;
}
