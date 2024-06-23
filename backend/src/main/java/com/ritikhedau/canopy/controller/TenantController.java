package com.ritikhedau.canopy.controller;
import com.ritikhedau.canopy.entity.Tenant;
import com.ritikhedau.canopy.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    @Autowired private TenantService service;

    @PostMapping
    public ResponseEntity<Tenant> create(@RequestBody Tenant t) {
        return ResponseEntity.ok(service.createTenant(t));
    }

    @GetMapping
    public ResponseEntity<List<Tenant>> list() {
        return ResponseEntity.ok(service.getActiveTenants());
    }
// minor tweak: performance check updates
}
// minor tweak: update verification rules and configs
