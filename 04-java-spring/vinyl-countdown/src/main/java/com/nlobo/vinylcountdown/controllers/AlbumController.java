package com.nlobo.vinylcountdown.controllers;

import com.nlobo.vinylcountdown.models.Album;
import com.nlobo.vinylcountdown.models.User;
import com.nlobo.vinylcountdown.services.AlbumService;
import com.nlobo.vinylcountdown.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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

    private AlbumService albumService;
    private UserService userService;

    public AlbumController(AlbumService albumService, UserService userService) {
        this.albumService = albumService;
        this.userService = userService;
    }

    @GetMapping("/albums")
    public String albums(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findById(userId);
        model.addAttribute("user", user);

        List<Album> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);

        return "albums.jsp";
    }

    @GetMapping("/albums/new")
    public String newAlbum(HttpSession session, @ModelAttribute("album") Album album, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findById(userId);
        model.addAttribute("user", user);

        return "newAlbum.jsp";
    }

    @PostMapping("/albums/create")
    public String createAlbum(@Valid @ModelAttribute("album") Album album, BindingResult bindingResult, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            return "newAlbum.jsp";
        }

        albumService.createAlbum(album);
        return "redirect:/albums";
    }

    @GetMapping("/albums/{albumId}")
    public String albumDetails(@PathVariable Long albumId, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findById(userId);
        model.addAttribute("user", user);

        Album album = albumService.getAlbumById(albumId);
        model.addAttribute("album", album);

        double average = albumService.getAverageOfScores(album);
        model.addAttribute("average", average);

        return "albumDetails.jsp";
    }

    @GetMapping("/albums/{albumId}/edit")
    public String editAlbum(@PathVariable Long albumId, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findById(userId);
        model.addAttribute("user", user);

        Album album = albumService.getAlbumById(albumId);
        model.addAttribute("album", album);

        if(!userId.equals(album.getCreator().getId())) {
            return "redirect:/";
        }

        return "editAlbum.jsp";
    }

    @PostMapping("/albums/{albumId}/update")
    public String updateAlbum(
            @PathVariable Long albumId,
            @Valid @ModelAttribute("album") Album album,
            BindingResult result,
            HttpSession session,
            Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            User user = userService.findById(userId);
            model.addAttribute("user", user);
            return "editAlbum.jsp";
        }

        albumService.updateAlbum(albumId, album);
        return "redirect:/albums/" + albumId;
    }

    @PostMapping("/albums/{albumId}/delete")
    public String deleteAlbum(@PathVariable Long albumId, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        albumService.deleteAlbum(albumId);
        return "redirect:/albums";
    }
}
