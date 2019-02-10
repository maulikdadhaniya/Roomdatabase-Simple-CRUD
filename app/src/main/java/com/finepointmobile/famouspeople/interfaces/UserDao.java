package com.finepointmobile.famouspeople.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.finepointmobile.famouspeople.model.User;

import java.util.List;

/**
 * Created by danielmalone on 10/28/17.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM mydatabasenew")
    List<User> getAllUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User... users);

    @Query("UPDATE mydatabasenew SET first_name= :firstName,last_name = :lastName,email = :email WHERE id = :id")
    void update(String firstName, String lastName, String email, int id);


}
