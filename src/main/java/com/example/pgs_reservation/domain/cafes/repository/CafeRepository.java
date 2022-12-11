package com.example.pgs_reservation.domain.cafes.repository;

import com.example.pgs_reservation.domain.cafes.entity.CafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<CafeEntity, Long> {
}
