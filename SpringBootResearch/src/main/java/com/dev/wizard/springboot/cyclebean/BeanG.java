package com.dev.wizard.springboot.cyclebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeanG {

    @Autowired
    private BeanH beanH;
}
