package com.test.mytestframework;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.test.mytestframework.data.Repository;
import com.test.mytestframework.data.source.local.Dao;
import com.test.mytestframework.data.source.local.internal.Database;
import com.test.mytestframework.data.source.remote.Webservice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(AndroidJUnit4.class)
public class RepositoryInstrumentedTest {
    private Dao mDao;
    private Database mDataBase;

    @Before
    public void createDb() {
        mDataBase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), Database.class).build();
        mDao = mDataBase.getDao();
    }

    @After
    public void closeDb() {
        mDataBase.close();
    }

    @Test
    public void testRepository() {
        Webservice webservice = Mockito.mock(Webservice.class);
        Repository repository = new Repository(mDao, webservice);
        repository.getEntity("test");
    }
}
