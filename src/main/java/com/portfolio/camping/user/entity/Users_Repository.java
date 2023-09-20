package com.portfolio.camping.user.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional; // null이 올 수 있는 값을 감싸는 Wrapper클래스. nullException 미연방지.

@Repository
public interface Users_Repository extends JpaRepository<Users,Long> {

    @Query("SELECT u FROM Users u WHERE u.user_email = ?1")
    Optional<Users> findByUser_Email(String user_email);

}
