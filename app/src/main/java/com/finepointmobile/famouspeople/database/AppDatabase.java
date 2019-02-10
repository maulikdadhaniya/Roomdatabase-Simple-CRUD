package com.finepointmobile.famouspeople.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.finepointmobile.famouspeople.model.User;
import com.finepointmobile.famouspeople.interfaces.UserDao;

/**
 * Created by danielmalone on 10/28/17.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
