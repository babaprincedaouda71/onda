package com.example.onda.service;

import com.example.onda.entity.Measurement;
import java.util.List;
import java.util.Optional;

public interface MeasurementService {
    List<Measurement> findAll();
    Optional<Measurement> findById(Long id);
    Measurement save(Measurement measurement);
    void deleteById(Long id);
}