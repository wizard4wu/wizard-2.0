package com.dev.wizard.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
public class BeanObject {


    public AsyncConfig asyncConfig(){
        AsyncConfig asyncConfig = null;
        try{
            asyncConfig = new AsyncConfig();
            asyncConfig.init();
        }catch (Exception e){
            log.error("faild");
        }

        return asyncConfig;
    }
}
