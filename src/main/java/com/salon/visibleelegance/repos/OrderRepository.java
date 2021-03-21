package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
