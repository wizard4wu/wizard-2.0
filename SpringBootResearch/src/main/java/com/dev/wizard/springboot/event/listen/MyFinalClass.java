package com.dev.wizard.springboot.event.listen;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * use the final class to test the cglib proxy
 */
@Service
@Slf4j
public class MyFinalClass {

    @Async
    private void finalClassMethod(){
        log.info("MyFinalClass + finalClassMethod");
    }
}
