package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
