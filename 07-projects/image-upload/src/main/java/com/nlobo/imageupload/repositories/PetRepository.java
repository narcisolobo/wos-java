package com.nlobo.imageupload.repositories;

import com.nlobo.imageupload.models.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> { }
