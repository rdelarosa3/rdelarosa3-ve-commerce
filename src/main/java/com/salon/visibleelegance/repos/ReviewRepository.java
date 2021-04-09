package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
