package com.nlobo.mythsandgods.services;

import com.nlobo.mythsandgods.models.Mythology;
import com.nlobo.mythsandgods.repositories.MythologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MythologyService {

    private final MythologyRepository mythologyRepository;

    public MythologyService(MythologyRepository mythologyRepository) {
        this.mythologyRepository = mythologyRepository;
    }

    public List<Mythology> getAll() {
        return (List<Mythology>) mythologyRepository.findAll();
    }

    public Mythology getById(Long id) {
        Optional<Mythology> mythology = mythologyRepository.findById(id);
        return mythology.orElse(null);
    }

    public Mythology create(Mythology mythology) {
        return mythologyRepository.save(mythology);
    }

}
