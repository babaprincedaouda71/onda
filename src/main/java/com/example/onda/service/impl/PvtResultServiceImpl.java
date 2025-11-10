package com.example.onda.service.impl;

import com.example.onda.entity.PvtResult;
import com.example.onda.repository.PvtResultRepository;
import com.example.onda.service.PvtResultService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PvtResultServiceImpl implements PvtResultService {

    private final PvtResultRepository pvtResultRepository;

    public PvtResultServiceImpl(PvtResultRepository pvtResultRepository) {
        this.pvtResultRepository = pvtResultRepository;
    }

    @Override
    public List<PvtResult> findAll() {
        return pvtResultRepository.findAll();
    }

    @Override
    public Optional<PvtResult> findById(Long id) {
        return pvtResultRepository.findById(id);
    }

    @Override
    public PvtResult save(PvtResult pvtResult) {
        return pvtResultRepository.save(pvtResult);
    }

    @Override
    public void deleteById(Long id) {
        pvtResultRepository.deleteById(id);
    }
}