package com.app.divyansh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.divyansh.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	Optional<Inventory> findByBookId(Long bookId);
}
