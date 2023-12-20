package com.dev.wizard.config;

import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CustomFeignLog extends feign.Logger{
    @Override
    protected void log(String configKey, String format, Object... args) {

        log.info("CustomFeignLog..., {}", format);
    }


    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response,
                                              long elapsedTime) throws IOException {

        return response;
    }
}
