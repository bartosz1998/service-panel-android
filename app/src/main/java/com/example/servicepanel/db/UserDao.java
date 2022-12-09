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
}
