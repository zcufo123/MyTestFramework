package com.test.mytestframework.data;


import com.test.mytestframework.data.source.local.Dao;
import com.test.mytestframework.data.source.remote.Webservice;

import javax.inject.Inject;

public class Repository {

    private Dao mDao;
    private Webservice mWebservice;

    @Inject
    public Repository(Dao dao, Webservice webservice) {
        mDao = dao;
        mWebservice = webservice;
    }

    public Entity getEntity(String id) {
        Entity entity = mDao.getEntity(id);
        if (entity == null) {
            entity = mWebservice.getEntity(id);
        }
        return entity;
    }
}
