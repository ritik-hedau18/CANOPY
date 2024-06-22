package com.ritikhedau.canopy.service;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    public String performAction(String action) {
        return "Action '" + action + "' processed successfully in BillingService.";
    }
}