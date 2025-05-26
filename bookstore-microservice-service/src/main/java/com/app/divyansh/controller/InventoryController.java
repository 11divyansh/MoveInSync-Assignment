package com.app.divyansh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.app.divyansh.model.Inventory;
import com.app.divyansh.service.InventoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/inventory")
@Tag(name = "Inventory", description = "Inventory management APIs")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Operation(summary = "Get all inventory items")
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAll();
    }

    @Operation(summary = "Get inventory by Book ID")
    @GetMapping("/book/{bookId}")
    public Inventory getByBookId(@PathVariable Long bookId) {
        return inventoryService.getByBookId(bookId).orElseThrow();
    }

    @Operation(summary = "Add inventory entry")
    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    @Operation(summary = "Update inventory entry")
    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable Long id, @RequestBody Inventory inventory) {
        return inventoryService.updateInventory(id, inventory);
    }

    @Operation(summary = "Delete inventory entry")
    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
    }
}