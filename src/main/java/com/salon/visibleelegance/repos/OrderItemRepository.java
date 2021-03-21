package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
