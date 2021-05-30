package com.example.roomdb;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao{
    @Query("SELECT * FROM MODEL")
    List<Model> getAll();

    @Query("SELECT first,last from model")
    List<NameTuple> loadFullName();

    @Insert
    void insertAll(Model ... models);

    @Insert
    void twoItem(Model model1,Model model2);

    @Insert
    void itemAndList(Model model,List<Model> list);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(Model ... models);

    @Insert
    long[] inertItem(Model ... model);

    @Delete
    int deleteItem(Model ...  model);

    @Update
    int updateItem(Model ... model);

    @Query("Insert into model('first','last','weight','tall') values(:m1,:m2,:m3,:m4)")
    void insertQuery(String m1,String m2,float m3,float m4);

    @Query("SELECT * FROM model WHERE tall>:tall")
    Model[] queryTall(float tall);

    @Query("SELECT * FROM model WHERE tall BETWEEN :minTall AND :maxTall")
    public Cursor queryBetween(float minTall, float maxTall);

    @Query("SELECT * FROM model WHERE first LIKE :text OR first Like :sub")
    List<Model> queryName(String text, String sub);

    @Query("SELECT * FROM model where first IN (:items)")
    List<Model> queryList(String ... items);

    @Query("SELECT * FROM notebook " +
            "Inner Join Skill on SKill.id = notebook.id ")
    List<Developer> queryList();

    @Query("SELECT * FROM notebook")
    List<NoteBook> getNoteBook();

    @Query("Insert into notebook('ram','cpu','gpu') values (:n1,:n2,:n3)")
    void notebookInsert(int n1,String n2,String n3);

    @Query("Select * From skill")
    List<Skill> getSkill();

    @Query("Insert into skill('language','framework') values(:s1,:s2)")
    void skillInsert(String s1,String s2);

    @Query("" +
            "Select notebook.gpu as gpuName,skill.framework as frameworkName  " +
            "from notebook,skill where notebook.id = skill.id")
    public LiveData<List<UserInfo>> loadJoinUserInfo();


    static class UserInfo{
        public String gpuName;
        public String frameworkName;
    }


}
