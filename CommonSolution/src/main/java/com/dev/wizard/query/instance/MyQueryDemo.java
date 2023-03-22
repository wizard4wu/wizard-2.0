package com.dev.wizard.query.instance;

import com.dev.wizard.query.PageQueryHelper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyQueryDemo {

    public static void main(String[] args) {
        MyQueryParam queryParam = new MyQueryParam();
        queryParam.setProductId("productId");
        //queryParam.setProtectThreshold(2);
        List<String> list = new ArrayList<>();
        PageQueryHelper.pageQuery(query -> {
            List<MyQueryPayload> result = getPayloadList(query.getOffset(), query.getPageSize());
            for (MyQueryPayload myQueryPayload : result) {
              list.add(myQueryPayload.getOrderId());
            }
            return result;
        }, queryParam);

        System.out.println(list.size());
    }


    private static List<MyQueryPayload> getPayloadList(int offset, int pageSize) {
        if(offset == 100){
            return Collections.emptyList();
        }
        return IntStream.range(offset, offset + pageSize).mapToObj(index -> {
            MyQueryPayload myQueryPayload = new MyQueryPayload();
            myQueryPayload.setProductId("productId");
            myQueryPayload.setOrderId("orderId_" + index);
            myQueryPayload.setCreatedTime(Instant.now().plusMillis(index * 1000L));
            return myQueryPayload;
        }).collect(Collectors.toList());
    }
}
