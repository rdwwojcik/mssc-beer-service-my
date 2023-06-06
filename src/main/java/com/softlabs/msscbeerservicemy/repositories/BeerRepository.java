package com.softlabs.msscbeerservicemy.repositories;

import com.softlabs.msscbeerservicemy.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
