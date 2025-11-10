package com.example.onda.web;

import com.example.onda.entity.Measurement;
import com.example.onda.service.MeasurementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    public List<Measurement> getAllMeasurements() {
        return measurementService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Measurement> getMeasurementById(@PathVariable Long id) {
        return measurementService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Measurement> createMeasurement(@RequestBody Measurement measurement) {
        Measurement savedMeasurement = measurementService.save(measurement);
        return new ResponseEntity<>(savedMeasurement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Measurement> updateMeasurement(@PathVariable Long id, @RequestBody Measurement measurement) {
        return measurementService.findById(id)
                .map(existingMeasurement -> {
                    measurement.setMeasurementId(id);
                    Measurement updatedMeasurement = measurementService.save(measurement);
                    return ResponseEntity.ok(updatedMeasurement);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasurement(@PathVariable Long id) {
        if (!measurementService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        measurementService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}