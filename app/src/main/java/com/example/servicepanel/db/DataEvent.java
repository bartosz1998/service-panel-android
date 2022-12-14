package com.example.servicepanel.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity
public class DataEvent {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "event_name")
    public String eventName;

    @ColumnInfo(name = "object")
    public String object;

    @ColumnInfo(name = "object_address")
    public String objectAddress;

    @ColumnInfo(name = "id_service")
    public String idService;

    @ColumnInfo(name = "status_Event")
    public String statusEvent;

    @ColumnInfo(name = "Local_date_start")
    public String dateStart;

    @ColumnInfo(name = "Local_date_stop")
    public String dateStop;
}



