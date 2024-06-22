package com.ritikhedau.canopy.service;
import com.ritikhedau.canopy.entity.Tenant;
import com.ritikhedau.canopy.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TenantService {
    @Autowired private TenantRepository repo;

    public Tenant createTenant(Tenant t) {
        t.setActive(true);
        return repo.save(t);
    }

    public List<Tenant> getActiveTenants() {
        return repo.findAll();
    }
}
// minor tweak: update verification rules and configs

// minor tweak: update verification rules and configs at 5205
