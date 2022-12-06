package com.example.servicepanel.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TimeEvent {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name="object_adress")
    public String object_adress;
}
