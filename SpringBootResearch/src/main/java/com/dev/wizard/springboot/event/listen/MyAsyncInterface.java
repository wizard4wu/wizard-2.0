package com.dev.wizard.springboot.event.listen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class AsyncWithoutInterface implements MyAsyncInterface {

    @Async
    public void asyncMethod(){
        log.info("AsyncWithoutInterface + asyncMethod");
        throw new RuntimeException();
    }
}

public interface MyAsyncInterface{
    void asyncMethod();

    default void method(){

    }
}