package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
