package com.test.mytestframework.di;

import android.content.Context;

import androidx.room.Room;

import com.test.mytestframework.data.source.local.Dao;
import com.test.mytestframework.data.source.local.internal.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    private static final String DB_NAME = "data.db";

    @Provides
    @Singleton
    public static Dao provideDao(Database database) {
        return database.getDao();
    }

    @Provides
    @Singleton
    public static Database provideDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                Database.class,
                DB_NAME
        ).build();
    }
}
