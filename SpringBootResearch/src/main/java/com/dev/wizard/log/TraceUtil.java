package com.dev.wizard.log;

import java.util.UUID;

public class TraceUtil {

    private static final String LOG_PREFIX = "AID_";

    public static String generateTrackingId(){
        return LOG_PREFIX + UUID.randomUUID();
    }

    public static void main(String[] args) {
        System.out.println(generateTrackingId());
    }
}
