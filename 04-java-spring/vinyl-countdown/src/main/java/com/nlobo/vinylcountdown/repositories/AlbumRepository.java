package com.nlobo.vinylcountdown.repositories;

import com.nlobo.vinylcountdown.models.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> { }
