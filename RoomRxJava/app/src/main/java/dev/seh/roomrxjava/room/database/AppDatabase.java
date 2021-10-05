package dev.seh.roomrxjava.room.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import dev.seh.roomrxjava.room.Dao.MainDao;
import dev.seh.roomrxjava.room.entitiy.MainEntity;

/**
 * @author : seungHo
 * @since : 2021-10-05
 * class : AppDatabase.java
 * github : devaspirant0510
 * email : seungho020510@gmail.com
 * description :
 */
@Database(entities = {MainEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String TAG = AppDatabase.class.getSimpleName();
    private final static String DB_NAME = "mainDB";
    public static AppDatabase instance = null;

    public abstract MainDao mainDao();

    public static AppDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DB_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(new RoomDatabase.Callback(){
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                        }
                    }).build();
            return instance;
        }
        return instance;
    }
}
