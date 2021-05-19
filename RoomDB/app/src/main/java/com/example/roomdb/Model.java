package com.example.roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Model {
    @PrimaryKey(autoGenerate = true)
    public int useId;

    @ColumnInfo(name = "first")
    public String firstName;

    @ColumnInfo (name="last")
    public String lastName;

    @Ignore
    public String phone;

    public Model(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
