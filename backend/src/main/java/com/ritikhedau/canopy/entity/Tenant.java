package com.ritikhedau.canopy.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Represents a tenant (organization) in the multi-tenant SaaS system.
 * Each tenant gets its own PostgreSQL schema for data isolation.
 */
@Entity
@Table(name = "tenants", schema = "public")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(name = "schema_name", nullable = false, unique = true)
    private String schemaName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private PlanType plan = PlanType.FREE;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private TenantStatus status = TenantStatus.ACTIVE;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum PlanType {
        FREE, PRO, ENTERPRISE
    }

    public enum TenantStatus {
        ACTIVE, SUSPENDED, DELETED
    }
}
