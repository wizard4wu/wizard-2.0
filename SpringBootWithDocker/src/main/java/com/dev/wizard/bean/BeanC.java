package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BeanC {

    public BeanC(){
        log.info("Constructor + BeanC");
    }
}
