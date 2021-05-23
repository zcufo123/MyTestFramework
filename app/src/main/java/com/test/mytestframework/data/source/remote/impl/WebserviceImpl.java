package com.test.mytestframework.data.source.remote.impl;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.test.mytestframework.data.Entity;
import com.test.mytestframework.data.source.remote.Webservice;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class WebserviceImpl implements Webservice {

    private SearchService mSearchService;

    @Inject
    public WebserviceImpl(SearchService searchService) {
        mSearchService = searchService;
    }

    public interface SearchService {
        @GET("/data/2.5/find")
        Call<Entity> getEntity(
                @Query("id") String id);
    }

    public static class EntityDeserializer implements JsonDeserializer<Entity> {
        @Override
        public Entity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject root = json.getAsJsonObject();
            String id = root.getAsJsonPrimitive("id").getAsString();
            String name = root.getAsJsonPrimitive("name").getAsString();
            Entity entity = new Entity(id);
            entity.name = name;
            return entity;
        }
    }

    @Override
    public Entity getEntity(String id) {
        mSearchService.getEntity(id);
        Call<Entity> call = mSearchService.getEntity(id);
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
