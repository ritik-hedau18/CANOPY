package com.ritikhedau.canopy.repository;

import com.ritikhedau.canopy.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Optional<Tenant> findBySlug(String slug);
// minor tweak: performance check updates
}

// minor tweak: update verification rules and configs
