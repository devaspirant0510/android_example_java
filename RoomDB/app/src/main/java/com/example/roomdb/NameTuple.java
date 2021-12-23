package com.example.roomdb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;

public class NameTuple {
    @ColumnInfo(name = "first")
    public String firstName;

    @ColumnInfo(name = "last")
    public String lastName;

}
