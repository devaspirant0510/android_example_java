package com.example.roomrelationship.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlayList {
    @PrimaryKey
    public  long listId;
    public long userCreateId;
}
