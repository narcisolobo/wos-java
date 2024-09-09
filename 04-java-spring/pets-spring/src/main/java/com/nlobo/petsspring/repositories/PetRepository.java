package com.nlobo.petsspring.repositories;

import com.nlobo.petsspring.models.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> { }
