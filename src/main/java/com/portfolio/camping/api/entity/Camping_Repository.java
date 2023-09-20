package com.portfolio.camping.api.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Camping_Repository extends JpaRepository<Camping, Long> {

    @Query("SELECT c FROM Camping c WHERE c.camping_type LIKE CONCAT('%',:type,'%')")
        //@Query(value = "select * from camping_info where camping_type like %?0%",nativeQuery=true )
    List<Camping> findBytype(String type);


    @Query("SELECT c FROM Camping c WHERE c.camping_natural LIKE CONCAT('%',:theme,'%')")
        //@Query("SELECT c FROM camping_info c WHERE c.camping_natural LIKE %?0%",nativeQuery=true)
    List<Camping> findBytheme(String theme);


}
