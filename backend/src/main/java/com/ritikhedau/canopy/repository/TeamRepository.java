package com.ritikhedau.canopy.repository;

import com.ritikhedau.canopy.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByTenantId(Long tenantId);
}

// minor tweak: update verification rules and configs
