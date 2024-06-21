package com.ritikhedau.canopy.repository;

import com.ritikhedau.canopy.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
