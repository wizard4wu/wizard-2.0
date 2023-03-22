package com.dev.wizard.log;


import com.dev.wizard.Constant;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Component
public class TrackingLogFilter extends AbstractRequestLoggingFilter {


    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        String trackingId = request.getHeader(Constant.TRACKING_ID);
        if(null == trackingId){
            trackingId = TraceUtil.generateTrackingId();
        }
        MDC.put(Constant.TRACKING_ID, trackingId);
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        MDC.remove(Constant.TRACKING_ID);
    }
}
