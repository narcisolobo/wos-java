package com.nlobo.mythsandgods.services;

import com.nlobo.mythsandgods.models.God;
import com.nlobo.mythsandgods.repositories.GodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GodService {

    private final GodRepository godRepository;

    public GodService(GodRepository godRepository) {
        this.godRepository = godRepository;
    }

    public List<God> findAll() {
        return (List<God>) this.godRepository.findAll();
    }

    public God getById(long id) {
        Optional<God> god = this.godRepository.findById(id);
        return god.orElse(null);
    }

    public God create(God god) {
        return this.godRepository.save(god);
    }
}
