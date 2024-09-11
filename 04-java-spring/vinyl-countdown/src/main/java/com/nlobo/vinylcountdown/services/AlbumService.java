package com.nlobo.vinylcountdown.services;

import com.nlobo.vinylcountdown.models.Album;
import com.nlobo.vinylcountdown.models.Rating;
import com.nlobo.vinylcountdown.models.User;
import com.nlobo.vinylcountdown.repositories.AlbumRepository;
import com.nlobo.vinylcountdown.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;
    public AlbumService(AlbumRepository albumRepository, UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
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

    public void likeAlbum(long albumId, long userId) {
        Album album = albumRepository.findById(albumId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        System.out.println(album.getTitle());
        System.out.println(user.getFirstName());

        if (album != null && user != null) {
            album.getLikingUsers().add(user);
            albumRepository.save(album);
        }
    }

    public double getAverageOfScores(Album album) {
        int sum = 0;
        for (Rating rating : album.getRatings()) {
            sum += rating.getScore();
        }
        return (double) sum / album.getRatings().size();
    }


}
