package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.BookedService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookedServiceRepository extends JpaRepository<BookedService,Long> {
}
