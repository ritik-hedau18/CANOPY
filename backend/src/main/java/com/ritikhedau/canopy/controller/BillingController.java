package com.ritikhedau.canopy.controller;

import com.ritikhedau.canopy.entity.Plan;
import com.ritikhedau.canopy.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {
    @Autowired
    private PlanRepository planRepository;

    @GetMapping("/plans")
    public ResponseEntity<List<Plan>> listPlans() {
        return ResponseEntity.ok(planRepository.findAll());
    }

    @PostMapping("/plans")
    public ResponseEntity<Plan> createPlan(@RequestBody Plan plan) {
        return ResponseEntity.ok(planRepository.save(plan));
    }
}