package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
