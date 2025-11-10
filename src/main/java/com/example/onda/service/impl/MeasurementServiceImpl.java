package com.example.onda.service.impl;

import com.example.onda.entity.Measurement;
import com.example.onda.repository.MeasurementRepository;
import com.example.onda.service.MeasurementService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;

    public MeasurementServiceImpl(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    @Override
    public Optional<Measurement> findById(Long id) {
        return measurementRepository.findById(id);
    }

    @Override
    public Measurement save(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    @Override
    public void deleteById(Long id) {
        measurementRepository.deleteById(id);
    }
}