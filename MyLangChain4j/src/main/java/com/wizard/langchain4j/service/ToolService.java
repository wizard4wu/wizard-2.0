package com.wizard.langchain4j.service;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;


public interface ToolService {
    @Tool("某地区的天气")
    String getWeather(@P("地区") String address, @P("天气") String weather);
}
