package com.example.onda.service;

import com.example.onda.entity.WorkSession;
import java.util.List;
import java.util.Optional;

public interface WorkSessionService {
    List<WorkSession> findAll();
    Optional<WorkSession> findById(Long id);
    WorkSession save(WorkSession workSession);
    void deleteById(Long id);
}