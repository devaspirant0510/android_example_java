package com.example.roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity
public class Model {
    @PrimaryKey(autoGenerate = true)
    public int useId;

    @ColumnInfo(name = "first")
    public String firstName;

    @ColumnInfo (name="last")
    public String lastName;

    public double weight;

    public double tall;

    @Ignore
    public String phone;

    public void init(String firstName, String lastName, double weight, double tall) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.tall = tall;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTall() {
        return tall;
    }

    public void setTall(double tall) {
        this.tall = tall;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
