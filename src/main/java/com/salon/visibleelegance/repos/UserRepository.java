package com.salon.visibleelegance.repos;

import com.salon.visibleelegance.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
