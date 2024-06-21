package com.ritikhedau.canopy.repository;

import com.ritikhedau.canopy.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    Optional<Invitation> findByToken(String token);
    List<Invitation> findByTenantId(Long tenantId);
}
