package com.test.mytestframework.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.mytestframework.data.source.remote.Webservice;
import com.test.mytestframework.data.source.remote.impl.WebserviceImpl;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule{

    private static final String SEARCH_URL = "http://api.openweathermap.org";

    @Provides
    @Singleton
    public static Webservice provideService(WebserviceImpl.SearchService searchService) {
        return new WebserviceImpl(searchService);
    }

    @Provides
    @Singleton
    public static WebserviceImpl.SearchService provideSearchService() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(List.class, new WebserviceImpl.EntityDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SEARCH_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(WebserviceImpl.SearchService.class);
    }
}
