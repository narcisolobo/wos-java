package com.nlobo.vinylcountdown.services;

import com.nlobo.vinylcountdown.models.Album;
import com.nlobo.vinylcountdown.repositories.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> getAllAlbums() {
        return (List<Album>) albumRepository.findAll();
    }

    public Album getAlbumById(long albumId) {
        Optional<Album> album = albumRepository.findById(albumId);
        return album.orElse(null);
    }

    public Album updateAlbum(long albumId, Album album) {
        Optional<Album> albumOptional = albumRepository.findById(albumId);
        if (albumOptional.isEmpty()) {
            return null;
        }

        Album albumToUpdate = albumOptional.get();
        albumToUpdate.setTitle(album.getTitle());
        albumToUpdate.setArtist(album.getArtist());
        albumToUpdate.setDescription(album.getDescription());
        return albumRepository.save(albumToUpdate);
    }

    public void deleteAlbum(long albumId) {
        albumRepository.deleteById(albumId);
    }
}
