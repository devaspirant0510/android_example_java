package com.example.roomrelationship.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

public class DogAndOwner {
    @Embedded
    public Owner owner;
    @Relation(
            parentColumn = "ownerId",
            entityColumn = "dogOwnerId")
    public Dog dog;
}
