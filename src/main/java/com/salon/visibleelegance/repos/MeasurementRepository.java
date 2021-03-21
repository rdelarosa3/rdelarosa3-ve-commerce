package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement,Long> {
}
