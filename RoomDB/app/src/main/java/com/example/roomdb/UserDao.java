package com.example.roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao{
    @Query("SELECT * FROM model")
    List<Model> getAll();

    @Insert
    void insertAll(Model ... models);

    @Insert
    void inertItem(Model model);

    @Delete
    void deleteItem(Model model);

    @Update
    void updateItem(Model model);


}
