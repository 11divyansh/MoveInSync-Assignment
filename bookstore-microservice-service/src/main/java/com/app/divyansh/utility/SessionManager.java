package com.app.divyansh.utility;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class SessionManager {
    private final Map<String, String> sessions = new ConcurrentHashMap<>();

    public String createSession(String username) {
        String token = UUID.randomUUID().toString(); 
        sessions.put(token, username);
        return token;
    }
    public String getUsername(String token) {
        return sessions.get(token);
    }
    public void invalidate(String token) {
        sessions.remove(token);
    }
    public boolean isValid(String token) {
        return sessions.containsKey(token);
    }
}