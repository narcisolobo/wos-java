package com.nlobo.testingdemo.repositories;

import com.nlobo.testingdemo.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> { }
