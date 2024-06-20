package com.ritikhedau.canopy.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * TeamMember — join table linking users to teams with a team-level role.
 */
@Entity
@Table(name = "team_members")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_id", nullable = false)
    private Long teamId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private TeamRole role = TeamRole.MEMBER;

    @CreationTimestamp
    @Column(name = "joined_at", updatable = false)
    private LocalDateTime joinedAt;

    public enum TeamRole {
        LEAD, MEMBER
    }
}

// minor tweak: update verification rules and configs
