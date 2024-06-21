package com.ritikhedau.canopy.repository;

import com.ritikhedau.canopy.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByTenantId(Long tenantId);
}

// minor tweak: update verification rules and configs
