package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BeanC {

    @Autowired
    private BeanB beanB;

    public BeanC(){
        log.info("Constructor + BeanC");
    }
}
