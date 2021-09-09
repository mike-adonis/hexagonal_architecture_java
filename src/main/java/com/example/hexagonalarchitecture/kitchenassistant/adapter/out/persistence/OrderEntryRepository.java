package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntryRepository extends JpaRepository<OrderEntryEntity, Long> {
}
