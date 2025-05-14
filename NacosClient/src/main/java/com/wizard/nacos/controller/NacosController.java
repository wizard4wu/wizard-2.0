package com.wizard.nacos.controller;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.NacosConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope

public class NacosController {

    @Autowired
    private NacosConfigService nacosConfigService;
    @GetMapping("/nacos/save")
    public void save() throws NacosException {


        nacosConfigService.publishConfig("dataId", "group", "value");
    }

    @GetMapping("/nacos/get")
    public String get() throws NacosException {

        return nacosConfigService.getConfig("dataId", "group", 5000);
    }
}
