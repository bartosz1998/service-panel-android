package com.example.servicepanel.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "event_name")
    public String eventName;

    @ColumnInfo(name = "event_date")
    public String eventDate;

    @ColumnInfo(name = "event_date_stop")
    public String eventDateStop;
}
