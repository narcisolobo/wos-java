package com.nlobo.vinylcountdown.repositories;

import com.nlobo.vinylcountdown.models.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

}
