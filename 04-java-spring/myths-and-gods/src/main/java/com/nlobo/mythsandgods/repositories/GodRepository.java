package com.nlobo.mythsandgods.repositories;

import com.nlobo.mythsandgods.models.God;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GodRepository extends CrudRepository<God, Long> { }
