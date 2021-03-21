package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.InventoryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryOrderRepository extends JpaRepository<InventoryOrder,Long> {
}
