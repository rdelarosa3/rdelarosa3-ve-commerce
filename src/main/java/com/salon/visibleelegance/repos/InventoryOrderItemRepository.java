package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.InventoryOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryOrderItemRepository extends JpaRepository<InventoryOrderItem, Long> {
}
