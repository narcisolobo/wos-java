package com.nlobo.albumsapi.controllers;

import com.nlobo.albumsapi.models.Album;
import com.nlobo.albumsapi.services.AlbumService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/albums?q=null";
    }

    @GetMapping("/albums")
    public String index(@RequestParam(value = "q", required = false) String query, Model model, @ModelAttribute Album album) {
        List<Album> allAlbums = this.getSortedAlbums(query);
        model.addAttribute("albums", allAlbums);
        model.addAttribute("album", album);
        return "albums.jsp";
    }

    public List<Album> getSortedAlbums(String query) {
        switch (query) {
            case "title":
                return this.albumService.sortedByTitle();
            case "artist":
                return this.albumService.sortedByArtist();
            case "release-date":
                return this.albumService.sortedByReleaseDate();
            default:
                return this.albumService.sortedByCreatedAt();
        }
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
        return "redirect:/albums?q=null";
    }

    @GetMapping("/albums/{albumId}/edit")
    public String editAlbum(@PathVariable Long albumId, Model model) {
        Album album = this.albumService.findAlbum(albumId);
        model.addAttribute("album", album);
        return "albumEdit.jsp";
    }

    @PutMapping("/albums/{albumId}/update")
    public String updateAlbum(
            @PathVariable Long albumId,
            @Valid @ModelAttribute Album album,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("album", album);
            return "albumEdit.jsp";
        }

        this.albumService.updateAlbum(albumId, album);
        return "redirect:/albums?q=null";
    }

    @DeleteMapping("/albums/{albumId}/delete")
    public String deleteAlbum(@PathVariable Long albumId) {
        this.albumService.deleteAlbum(albumId);
        return "redirect:/albums?q=null";
    }

    @PostMapping("/albums/search")
    public String searchAlbums(@RequestParam String title, Model model) {
        List<Album> foundAlbums = this.albumService.searchByTitle(title);
        model.addAttribute("albums", foundAlbums);
        return "searchResults.jsp";
    }

    @GetMapping("/albums/sort/title")
    public String sortAlbumsTitle() {
        return "redirect:/albums?q=title";
    }

    @GetMapping("/albums/sort/artist")
    public String sortAlbumsArtist() {
        return "redirect:/albums?q=artist";
    }

    @GetMapping("/albums/sort/release-date")
    public String sortAlbumsReleaseDate() {
        return "redirect:/albums?q=release-date";
    }
}
