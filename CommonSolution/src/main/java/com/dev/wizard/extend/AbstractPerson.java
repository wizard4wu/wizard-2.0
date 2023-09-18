package com.dev.wizard.extend;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractPerson {

    Parent getData(){
        log.info("AbstractPerson + Parent");
        return new Parent();
    }
}
