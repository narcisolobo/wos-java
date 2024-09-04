package com.nlobo.albumsapi.services;

import com.nlobo.albumsapi.models.Album;
import com.nlobo.albumsapi.repositories.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> findAll() {
        return this.albumRepository.findAll();
    }

    public Album create(Album album) {
        return this.albumRepository.save(album);
    }
}
