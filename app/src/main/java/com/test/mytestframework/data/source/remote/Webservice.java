package com.test.mytestframework.data.source.remote;

import com.test.mytestframework.data.Entity;

public interface Webservice {
    Entity getEntity(String id);
}
