package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.AppointmentItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentItemRepository extends JpaRepository<AppointmentItem,Long> {
}
