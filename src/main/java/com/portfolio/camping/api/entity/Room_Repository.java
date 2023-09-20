package com.portfolio.camping.api.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Room_Repository extends JpaRepository<Room,Long> {

    @Query("SELECT r FROM Room r WHERE r.camping_no = ?1")
    List<Room> findByCamping_no(Long camping_no);

}
