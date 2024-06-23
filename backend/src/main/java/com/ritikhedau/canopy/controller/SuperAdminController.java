package com.ritikhedau.canopy.controller;

import com.ritikhedau.canopy.entity.Tenant;
import com.ritikhedau.canopy.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/superadmin")
public class SuperAdminController {
    @Autowired
    private TenantRepository tenantRepository;

    @GetMapping("/tenants")
    public ResponseEntity<List<Tenant>> listTenants() {
        return ResponseEntity.ok(tenantRepository.findAll());
    }

    @PostMapping("/tenants")
    public ResponseEntity<Tenant> createTenant(@RequestBody Tenant tenant) {
        return ResponseEntity.ok(tenantRepository.save(tenant));
    }
}