package com.nlobo.albumsapi.services;

import com.nlobo.albumsapi.models.Album;
import com.nlobo.albumsapi.repositories.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    // find all albums
    public List<Album> findAllAlbums() {
        return this.albumRepository.findAll();
    }

    // create new album
    public Album createAlbum(Album album) {
        return this.albumRepository.save(album);
    }

    // find one album by id
    public Album findAlbum(Long id) {
        Optional<Album> optionalAlbum = this.albumRepository.findById(id);
        return optionalAlbum.orElse(null);
    }

    public Album updateAlbum(Long id, Album album) {
        Optional<Album> optionalAlbum = this.albumRepository.findById(id);
        if (optionalAlbum.isPresent()) {
            Album albumToUpdate = optionalAlbum.get();
            albumToUpdate.setTitle(album.getTitle());
            albumToUpdate.setArtist(album.getArtist());
            albumToUpdate.setReleaseDate(album.getReleaseDate());
            return this.albumRepository.save(albumToUpdate);
        }

        return null;
    }

    public void deleteAlbum(Long id) {
        this.albumRepository.deleteById(id);
    }
}
