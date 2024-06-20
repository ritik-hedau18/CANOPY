package com.ritikhedau.canopy.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Invitation entity — tracks pending invitations to join a tenant org.
 * Stored in public schema since invitees may not have accounts yet.
 */
@Entity
@Table(name = "invitations", schema = "public")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private User.Role role = User.Role.MEMBER;

    @Column(nullable = false, unique = true)
    @Builder.Default
    private String token = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private InvitationStatus status = InvitationStatus.PENDING;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public enum InvitationStatus {
        PENDING, ACCEPTED, EXPIRED, REVOKED
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiresAt);
    }
// minor tweak: performance check updates
}

// minor tweak: update verification rules and configs
