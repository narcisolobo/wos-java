package com.nlobo.beltexam.repositories;

import com.nlobo.beltexam.models.Movie;
import com.nlobo.beltexam.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findByCreator(User creator);
}
