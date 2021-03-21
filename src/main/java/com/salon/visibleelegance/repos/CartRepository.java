package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
