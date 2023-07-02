package com.dev.wizard.redis.common;

public interface PageCacheData<T> {

    T retrievePayload();

    double retrieveToken();
}
