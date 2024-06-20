package com.ritikhedau.canopy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * Plan entity — defines SaaS subscription tiers with feature limits.
 * Stored in public schema as plans are global across all tenants.
 */
@Entity
@Table(name = "plans", schema = "public")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "max_users", nullable = false)
    private Integer maxUsers;

    @Column(name = "max_teams", nullable = false)
    private Integer maxTeams;

    @Column(name = "max_api_calls_per_day", nullable = false)
    @Builder.Default
    private Integer maxApiCallsPerDay = 1000;

    @Column(columnDefinition = "TEXT")
    private String features;

    @Column(name = "price_monthly", nullable = false, precision = 10, scale = 2)
    private BigDecimal priceMonthly;

    @Column(name = "is_active")
    @Builder.Default
    private Boolean isActive = true;
}
