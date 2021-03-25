package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.BusinessHour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuisnessHourRepository extends JpaRepository<BusinessHour,Long> {
}
