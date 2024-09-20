package com.nlobo.imageupload.services;

import com.nlobo.imageupload.models.Pet;
import com.nlobo.imageupload.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getPets() {
        return (List<Pet>) petRepository.findAll();
    }

    public Pet getPet(long id) {
        Optional<Pet> pet = petRepository.findById(id);
        return pet.orElse(null);
    }

    public Pet updatePet(long id, Pet pet) {
        Optional<Pet> petOptional = petRepository.findById(id);
        if (petOptional.isEmpty()) {
            return null;
        }

        Pet petToUpdate = petOptional.get();
        petToUpdate.setName(pet.getName());
        petToUpdate.setBreed(pet.getBreed());
        petToUpdate.setImageUrl(pet.getImageUrl());
        petToUpdate.setImageDescription(pet.getImageDescription());
        return petRepository.save(petToUpdate);
    }

    public void deletePet(long id) {
        petRepository.deleteById(id);
    }
}
