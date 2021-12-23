package com.example.roomrelationship.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

/**
 * @author seungho
 * @project RoomRelationship
 * @class UserAndLibrary.java
 * @github devaspirant0510
 * @email seungho020510@gmail.com
 * @description
 * @since 2021-06-13
 **/
public class UserAndLibrary {
    @Embedded
    public User user;

    @Relation(
            parentColumn = "userId",
            entityColumn = "listId"
    )
    public PlayList playList;




}
