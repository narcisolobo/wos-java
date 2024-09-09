package com.nlobo.petsspring.services;

import com.nlobo.petsspring.models.Pet;
import com.nlobo.petsspring.repositories.PetRepository;
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

    public List<Pet> getAllPets() {
        return (List<Pet>) petRepository.findAll();
    }

    public Pet getPetById(Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        return pet.orElse(null);
    }

    public Pet updatePet(Pet pet) {
        Optional<Pet> petOptional = petRepository.findById(pet.getId());
        if (petOptional.isEmpty()) {
            return null;
        }

        Pet petToUpdate = petOptional.get();
        petToUpdate.setName(pet.getName());
        petToUpdate.setType(pet.getType());
        petToUpdate.setAge(pet.getAge());
        return petRepository.save(pet);
    }

    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }
}
