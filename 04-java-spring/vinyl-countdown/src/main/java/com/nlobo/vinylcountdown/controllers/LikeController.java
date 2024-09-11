package com.nlobo.vinylcountdown.controllers;

import com.nlobo.vinylcountdown.services.AlbumService;
import com.nlobo.vinylcountdown.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LikeController {

    private final UserService userService;
    private final AlbumService albumService;
    public LikeController(UserService userService, AlbumService albumService) {
        this.userService = userService;
        this.albumService = albumService;
    }

    @PostMapping("/likes/create")
    public String likeAlbum(@RequestParam("likerId") Long likerId, @RequestParam("albumId") Long albumId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null || albumId == null) {
            return "redirect:/";
        }

        System.out.println(likerId);
        System.out.println(albumId);

        albumService.likeAlbum(albumId, likerId);
        return "redirect:/albums/" + albumId;
    }
}
