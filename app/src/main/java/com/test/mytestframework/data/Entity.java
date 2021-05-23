package com.test.mytestframework.data;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.Setter;

@androidx.room.Entity(tableName = "Entities")
public class Entity {

    @PrimaryKey
    @NotNull
    @Getter
    @Setter
    public String id;

    @ColumnInfo(name = "name")
    @Getter
    @Setter
    public String name;

    public Entity(String id) {
        this.id = id;
    }
}
