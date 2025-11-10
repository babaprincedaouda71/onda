package com.example.onda.service;

import com.example.onda.entity.PvtResult;
import java.util.List;
import java.util.Optional;

public interface PvtResultService {
    List<PvtResult> findAll();
    Optional<PvtResult> findById(Long id);
    PvtResult save(PvtResult pvtResult);
    void deleteById(Long id);
}