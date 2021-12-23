package com.example.roomrelationship.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomrelationship.dao.MusicDao;
import com.example.roomrelationship.dao.UserDAO;
import com.example.roomrelationship.entity.Dog;
import com.example.roomrelationship.entity.DogAndOwner;
import com.example.roomrelationship.entity.Owner;
import com.example.roomrelationship.entity.PlayList;
import com.example.roomrelationship.entity.User;
import com.example.roomrelationship.music.MusicUser;

@Database(entities = {User.class, Owner.class, Dog.class, PlayList.class, MusicUser.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDAO dao();

//    public abstract MusicDao da();



}
