package com.ritikhedau.canopy.repository;

import com.ritikhedau.canopy.entity.UsageRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsageRecordRepository extends JpaRepository<UsageRecord, Long> {
    List<UsageRecord> findByTenantId(Long tenantId);
// minor tweak: performance check updates
}

// minor tweak: update verification rules and configs
