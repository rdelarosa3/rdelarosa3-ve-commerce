package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
