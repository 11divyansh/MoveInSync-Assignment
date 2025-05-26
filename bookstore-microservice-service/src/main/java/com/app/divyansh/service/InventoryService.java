package com.app.divyansh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.divyansh.model.Inventory;
import com.app.divyansh.repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getByBookId(Long bookId) {
        return inventoryRepository.findByBookId(bookId);
    }

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(Long id, Inventory inventory) {
        inventory.setId(id);
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}