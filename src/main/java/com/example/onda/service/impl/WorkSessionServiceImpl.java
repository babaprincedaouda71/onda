package com.example.onda.service.impl;

import com.example.onda.entity.WorkSession;
import com.example.onda.repository.WorkSessionRepository;
import com.example.onda.service.WorkSessionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkSessionServiceImpl implements WorkSessionService {

    private final WorkSessionRepository workSessionRepository;

    public WorkSessionServiceImpl(WorkSessionRepository workSessionRepository) {
        this.workSessionRepository = workSessionRepository;
    }

    @Override
    public List<WorkSession> findAll() {
        return workSessionRepository.findAll();
    }

    @Override
    public Optional<WorkSession> findById(Long id) {
        return workSessionRepository.findById(id);
    }

    @Override
    public WorkSession save(WorkSession workSession) {
        return workSessionRepository.save(workSession);
    }

    @Override
    public void deleteById(Long id) {
        workSessionRepository.deleteById(id);
    }
}