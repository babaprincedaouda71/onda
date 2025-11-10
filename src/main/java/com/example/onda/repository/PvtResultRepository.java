package com.example.onda.repository;

import com.example.onda.entity.PvtResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PvtResultRepository extends JpaRepository<PvtResult, Long> {
}