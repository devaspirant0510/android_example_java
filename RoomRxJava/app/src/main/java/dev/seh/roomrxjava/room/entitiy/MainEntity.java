package dev.seh.roomrxjava.room.entitiy;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author : seungHo
 * @since : 2021-10-05
 * class : MainEntity.java
 * github : devaspirant0510
 * email : seungho020510@gmail.com
 * description :
 */
@Entity
public class MainEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String introduce;
    @ColumnInfo
    private int age;
    @ColumnInfo
    private boolean gender;
    public MainEntity(){

    }
    public MainEntity( String name, String introduce, int age, boolean gender) {
        this.name = name;
        this.introduce = introduce;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
