package com.nlobo.albumsapi.repositories;

import com.nlobo.albumsapi.models.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
    List<Album> findByTitleContaining(String title);
    List<Album> findAllByOrderByTitle();
    List<Album> findAllByOrderByArtist();
    List<Album> findAllByOrderByReleaseDate();
    List<Album> findAllByOrderByCreatedAt();
}
