package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
