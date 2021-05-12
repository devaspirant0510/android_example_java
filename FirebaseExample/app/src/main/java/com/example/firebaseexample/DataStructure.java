package com.example.firebaseexample;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class DataStructure {
    public String title;
    public String text;

    public DataStructure(){

    }

    public DataStructure(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
