package com.test.mytestframework.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.test.mytestframework.data.Entity;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@androidx.room.Dao
public interface Dao {

    @Insert(onConflict = REPLACE)
    void insert(Entity... entities);

    @Delete
    void delete(Entity... cities);

    @Update
    void update(Entity... cities);

    @Query("SELECT * FROM Entities")
    List<Entity> getEntities();

    @Query("SELECT * FROM Entities WHERE id = :id")
    Entity getEntity(String id);

    @Query("SELECT * FROM Entities")
    LiveData<List<Entity>> observeEntities();

    @Query("SELECT * FROM Entities WHERE id = :id")
    LiveData<Entity> observeEntity(String id);
}
