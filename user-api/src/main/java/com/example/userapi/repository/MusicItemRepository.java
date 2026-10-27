package com.example.userapi.repository;

import com.example.userapi.dto.MusicIDCustomerName;
import com.example.userapi.entity.MusicItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MusicItemRepository extends JpaRepository<MusicItems, Long> {
    @Query("""
            select new com.example.userapi.dto.MusicIDCustomerName(m.id, c.name)
            from MusicItems m
            join m.customer c
            where m.id = :id
            """)
    Optional<MusicIDCustomerName> findSummaryById(@Param("id") Long id);
}
