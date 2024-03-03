package com.happyride.rideshare.Repository;

import com.happyride.rideshare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByMobileNo(String mobileNo);
    User findByUserId(Integer id);
}
