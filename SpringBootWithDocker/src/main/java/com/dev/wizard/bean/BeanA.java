package com.dev.wizard.bean;

import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
public class BeanA implements InitializingBean {

    public BeanA(){
       log.info("Constructor + BeanA");
    }

    @PostConstruct
    public void postConstruct(){
        log.info("postConstruct + BeanA");
    }

    public void init(){
        log.info("init + BeanA");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet + BeanA");
    }
}

