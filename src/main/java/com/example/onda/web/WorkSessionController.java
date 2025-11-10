package com.example.onda.web;

import com.example.onda.entity.WorkSession;
import com.example.onda.service.WorkSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-sessions")
public class WorkSessionController {

    private final WorkSessionService workSessionService;

    public WorkSessionController(WorkSessionService workSessionService) {
        this.workSessionService = workSessionService;
    }

    @GetMapping
    public List<WorkSession> getAllWorkSessions() {
        return workSessionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkSession> getWorkSessionById(@PathVariable Long id) {
        return workSessionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WorkSession> createWorkSession(@RequestBody WorkSession workSession) {
        WorkSession savedWorkSession = workSessionService.save(workSession);
        return new ResponseEntity<>(savedWorkSession, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkSession> updateWorkSession(@PathVariable Long id, @RequestBody WorkSession workSession) {
        return workSessionService.findById(id)
                .map(existingWorkSession -> {
                    workSession.setSessionId(id);
                    WorkSession updatedWorkSession = workSessionService.save(workSession);
                    return ResponseEntity.ok(updatedWorkSession);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkSession(@PathVariable Long id) {
        if (!workSessionService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        workSessionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}