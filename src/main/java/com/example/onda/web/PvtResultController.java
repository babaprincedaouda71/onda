package com.example.onda.web;

import com.example.onda.entity.PvtResult;
import com.example.onda.service.PvtResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pvt-results")
public class PvtResultController {

    private final PvtResultService pvtResultService;

    public PvtResultController(PvtResultService pvtResultService) {
        this.pvtResultService = pvtResultService;
    }

    @GetMapping
    public List<PvtResult> getAllPvtResults() {
        return pvtResultService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PvtResult> getPvtResultById(@PathVariable Long id) {
        return pvtResultService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PvtResult> createPvtResult(@RequestBody PvtResult pvtResult) {
        PvtResult savedPvtResult = pvtResultService.save(pvtResult);
        return new ResponseEntity<>(savedPvtResult, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PvtResult> updatePvtResult(@PathVariable Long id, @RequestBody PvtResult pvtResult) {
        return pvtResultService.findById(id)
                .map(existingPvtResult -> {
                    pvtResult.setPvtId(id);
                    PvtResult updatedPvtResult = pvtResultService.save(pvtResult);
                    return ResponseEntity.ok(updatedPvtResult);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePvtResult(@PathVariable Long id) {
        if (!pvtResultService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pvtResultService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}