package com.ritikhedau.canopy.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * UsageRecord — tracks metered usage per tenant per metric per period.
 * Stored in public schema to allow cross-tenant usage reporting.
 */
@Entity
@Table(name = "usage_records", schema = "public")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UsageRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;

    @Column(nullable = false)
    private String metric;

    @Column(nullable = false)
    @Builder.Default
    private Long count = 0L;

    @Column(nullable = false)
    private String period;

    @CreationTimestamp
    @Column(name = "recorded_at", updatable = false)
    private LocalDateTime recordedAt;
}
