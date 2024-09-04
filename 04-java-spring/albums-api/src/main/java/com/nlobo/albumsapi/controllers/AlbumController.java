package com.nlobo.albumsapi.controllers;

import com.nlobo.albumsapi.models.Album;
import com.nlobo.albumsapi.services.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/api/albums")
    public List<Album> getAlbums() {
        return albumService.findAll();
    }

    @PostMapping("/api/albums")
    public Album createAlbum(@RequestBody Album newAlbum) {
        return this.albumService.create(newAlbum);
    }
}
