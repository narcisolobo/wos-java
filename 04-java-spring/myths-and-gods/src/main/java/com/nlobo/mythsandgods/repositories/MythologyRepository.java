package com.nlobo.mythsandgods.repositories;

import com.nlobo.mythsandgods.models.Mythology;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MythologyRepository extends CrudRepository<Mythology, Long> { }
