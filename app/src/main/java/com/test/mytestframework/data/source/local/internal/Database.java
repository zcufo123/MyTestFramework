package com.test.mytestframework.data.source.local.internal;

import androidx.room.RoomDatabase;

import com.test.mytestframework.data.Entity;
import com.test.mytestframework.data.source.local.Dao;

@androidx.room.Database(entities = {Entity.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract Dao getDao();
}
