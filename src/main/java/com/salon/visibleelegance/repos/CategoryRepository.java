package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
