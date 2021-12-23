package com.example.roomrelationship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.roomrelationship.dao.UserDAO;
import com.example.roomrelationship.entity.Address;
import com.example.roomrelationship.entity.Dog;
import com.example.roomrelationship.entity.DogAndOwner;
import com.example.roomrelationship.entity.Owner;
import com.example.roomrelationship.entity.PlayList;
import com.example.roomrelationship.entity.User;
import com.example.roomrelationship.entity.UserAndLibrary;
import com.example.roomrelationship.music.MusicUser;
import com.example.roomrelationship.roomdb.AppDataBase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    private AppDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         dataBase = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class,"db1").allowMainThreadQueries().build();
         oneToOne();
    }
    private void embeddedObject(){
        UserDAO dao = dataBase.dao();
        // load db

        List<User> list = dao.getAll();

        User insertUser = new User();
        Address address = new Address();

        address.init("삼성로","대치동","서울시",123);
        insertUser.address = address;
        insertUser.firstName = "승호";


    }
    private void oneToOne(){
        UserDAO dao = dataBase.dao();
        MusicUser musicUser = new MusicUser();
        PlayList playList = new PlayList();
        musicUser.userId = 1;
        musicUser.age = 20;
        musicUser.name = "seungho";

        playList.listId = 2;
        playList.userCreateId = 1;
        dao.insertEmbeddedUserAddress(musicUser,playList);

        List<UserAndLibrary> list =dao.getUserLibrary();
        for (UserAndLibrary item : list){
            Log.e(TAG, "oneToOne: "+item.playList+item.user.userId+item.user.firstName+item.user.address );
        }

    }

}