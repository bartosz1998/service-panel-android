package com.example.servicepanel.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM dataEvent")
    List<DataEvent> getAllUsers();

    @Insert
    void insertUser(DataEvent... dataEvent);

    @Delete
    void delete (DataEvent dataEvent);

    @Query("DELETE FROM DataEvent WHERE uid = :id")
    void deleteById(int id);

    @Query("update DataEvent SET event_name= :eventName,object= :object, object_address= :objectAddress, status_Event= :statusEvent, Local_date_start= :dateStart, Local_date_stop = :dateStop where `uid`= :key")
    void updateData(String eventName, String object ,String objectAddress, String statusEvent, String dateStart, String dateStop, int key);

    @Query("update DataEvent SET Local_date_stop =:dateStop where `uid`= :key")
    void updateDateStop(String dateStop, int key);
}
