package com.nlobo.albumsapi.controllers;

import com.nlobo.albumsapi.models.Album;
import com.nlobo.albumsapi.services.AlbumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/albums";
    }

    @GetMapping("/albums")
    public String index(Model model, @ModelAttribute Album album) {
        List<Album> allAlbums = this.albumService.findAllAlbums();
        model.addAttribute("albums", allAlbums);
        model.addAttribute("album", album);
        return "albums.jsp";
    }

    @GetMapping("/albums/{albumId}")
    public String albumDetails(@PathVariable Long albumId, Model model) {
        Album album = this.albumService.findAlbum(albumId);
        model.addAttribute("album", album);
        return "albumDetails.jsp";
    }

    @PostMapping("/albums/create")
    public String createAlbum(@Valid @ModelAttribute Album album, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Album> allAlbums = this.albumService.findAllAlbums();
            model.addAttribute("albums", allAlbums);
            return "albums.jsp";
        }

        this.albumService.createAlbum(album);
        return "redirect:/albums";
    }
}
