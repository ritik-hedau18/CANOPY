package com.ritikhedau.canopy.service;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {
    public String performAction(String action) {
        return "Action '" + action + "' processed successfully in AuditLogService.";
    }
}