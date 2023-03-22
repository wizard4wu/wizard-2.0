package com.dev.wizard.query;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Function;

public class PageQueryHelper {

    private static final Set<String> NEGATIVE_ID_SET = new CopyOnWriteArraySet<>();


    public static <T> void pageQuery(Function<QueryParam<T>, List<? extends PageResultPayload<T>>> function, QueryParam<T> queryParam){
        int size = 0;

        String bizKey = queryParam.retrieveBizKey();
        if(StringUtils.isNotBlank(bizKey) && NEGATIVE_ID_SET.contains(bizKey)){
            return;
        }
        do {
            List<? extends PageResultPayload<T>> result =  function.apply(queryParam);
            if(null != result && (size = result.size()) >= queryParam.getPageSize()){
                PageResultPayload<T> pageQueryPayload = result.get(queryParam.getPageSize() - 1);
                queryParam.setNextPageToken(pageQueryPayload.retrieveNextPageToken());
                queryParam.increasePageNum();
            }
            queryParam.increaseProtectCounter();
        } while (size >= queryParam.getPageSize() && queryParam.getProtectCounter() < queryParam.getProtectThreshold());

        if(queryParam.getProtectCounter() >= queryParam.getProtectThreshold() && StringUtils.isNoneBlank(bizKey)){
            NEGATIVE_ID_SET.add(bizKey);
        }
    }
}
