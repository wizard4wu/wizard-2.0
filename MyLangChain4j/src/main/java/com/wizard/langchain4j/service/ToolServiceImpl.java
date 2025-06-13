package com.wizard.langchain4j.service;

import dev.langchain4j.agent.tool.P;
import org.springframework.stereotype.Service;

@Service
public class ToolServiceImpl implements ToolService {
    @Override
    public String getWeather(String address, String weather){
        //todo add your business code
        System.out.println(weather + " -- " +address);
        return "浙江杭州";
    }
}
