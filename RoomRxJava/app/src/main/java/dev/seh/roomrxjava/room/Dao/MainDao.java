package dev.seh.roomrxjava.room.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import dev.seh.roomrxjava.room.entitiy.MainEntity;
import io.reactivex.Completable;

@Dao
public interface MainDao {
    @Query("select * from MainEntity")
    List<MainEntity> getAllData();

    @Insert
    Completable createData(MainEntity entity);


}
