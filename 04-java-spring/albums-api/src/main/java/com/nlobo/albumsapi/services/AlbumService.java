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
        return (List<Album>) albumRepository.findAll();
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

    // update one album
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

    // delete one album by id
    public void deleteAlbum(Long id) {
        this.albumRepository.deleteById(id);
    }

    // search by title
    public List<Album> searchByTitle(String title) {
        return this.albumRepository.findByTitleContaining(title);
    }

    public List<Album> sortedByTitle() {
        return this.albumRepository.findAllByOrderByTitle();
    }

    public List<Album> sortedByArtist() {
        return this.albumRepository.findAllByOrderByArtist();
    }

    public List<Album> sortedByCreatedAt() {
        return this.albumRepository.findAllByOrderByCreatedAt();
    }

    public List<Album> sortedByReleaseDate() {
        return this.albumRepository.findAllByOrderByReleaseDate();
    }
}
