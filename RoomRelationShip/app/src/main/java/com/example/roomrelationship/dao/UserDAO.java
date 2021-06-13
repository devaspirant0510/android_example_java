package com.example.roomrelationship.dao;

import androidx.room.Dao;
import androidx.room.Embedded;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomrelationship.entity.Address;
import com.example.roomrelationship.entity.Dog;
import com.example.roomrelationship.entity.DogAndOwner;
import com.example.roomrelationship.entity.Owner;
import com.example.roomrelationship.entity.PlayList;
import com.example.roomrelationship.entity.User;
import com.example.roomrelationship.entity.UserAndLibrary;
import com.example.roomrelationship.music.MusicUser;

import java.util.List;
@Dao
public abstract class UserDAO {
    @Query("select * From user")
    public abstract List<User> getAll();

    @Insert
    public abstract void insertMusicUser(MusicUser musicUser);

    @Insert
    public abstract void insertPlayList(PlayList playList);

    @Transaction
    @Insert
    public void insertEmbeddedUserAddress(MusicUser user, PlayList playList){
        insertMusicUser(user);
        insertPlayList(playList);
    }



    @Transaction
    @Query("select * from Owner")
    public abstract List<DogAndOwner> getOne2One();

    @Insert
    public abstract void addDog(Dog dog);

    @Insert
    public abstract void addOwner(Owner owner);

    @Insert
    public abstract void insertOne2One(Owner owner);

    @Query("SELECT * FROM user")
    public abstract List<UserAndLibrary> getUserLibrary();
}
