package com.nlobo.albumsapi.controllers;

import com.nlobo.albumsapi.models.Album;
import com.nlobo.albumsapi.services.AlbumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/api/albums")
    public List<Album> getAlbums() {
        return albumService.findAllAlbums();
    }

    @PostMapping("/api/albums")
    public Album createAlbum(@RequestBody Album newAlbum) {
        return this.albumService.createAlbum(newAlbum);
    }

    @GetMapping("/api/albums/{albumId}")
    public Album getAlbum(@PathVariable(value = "albumId") long albumId) {
        return this.albumService.findAlbum(albumId);
    }

    @PutMapping("/api/albums/{albumId}")
    public Album updateAlbum(@PathVariable(value = "albumId") long albumId, @RequestBody Album updatedAlbum) {
        return this.albumService.updateAlbum(albumId, updatedAlbum);
    }

    @DeleteMapping("/api/albums/{albumId}")
    public void deleteAlbum(@PathVariable(value = "albumId") long albumId) {
        this.albumService.deleteAlbum(albumId);
    }
}
