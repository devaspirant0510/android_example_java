package com.example.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Model.class,Developer.class,Skill.class,NoteBook.class},
        version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

}
