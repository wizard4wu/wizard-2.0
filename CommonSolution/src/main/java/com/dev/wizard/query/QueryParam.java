package com.dev.wizard.query;

import lombok.Data;

@Data
public abstract class QueryParam<T> implements PageQuery<T>{
    private int protectThreshold = SECURITY_THRESHOLD;

    private int protectCounter;

    private int pageNum = 1;

    private int pageSize = 20;

    private T nextPageToken;

    public int getOffset() {
        return (pageNum - 1) * pageSize;
    }

    public void increasePageNum() {
        ++pageNum;
    }

    public void increaseProtectCounter() {
        ++protectCounter;
    }

    public abstract String retrieveBizKey();
}
