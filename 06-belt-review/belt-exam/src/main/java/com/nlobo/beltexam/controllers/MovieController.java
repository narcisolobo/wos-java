package com.nlobo.beltexam.controllers;

import com.nlobo.beltexam.models.Movie;
import com.nlobo.beltexam.models.User;
import com.nlobo.beltexam.services.MovieService;
import com.nlobo.beltexam.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {

    private UserService userService;
    private MovieService movieService;
    public MovieController(UserService userService, MovieService movieService) {
        this.userService = userService;
        this.movieService = movieService;
    }

    @GetMapping("/movies/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findById(userId);
        model.addAttribute("user", user);

        List<Movie> movies = movieService.getMovies();
        model.addAttribute("movies", movies);

        List<Movie> createdMovies = movieService.getCreatedMovies(user);
        model.addAttribute("createdMovies", createdMovies);
        return "dashboard.jsp";
    }

    @GetMapping("/movies/new")
    public String newMovie(HttpSession session, Model model, @ModelAttribute("movie") Movie movie) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findById(userId);
        model.addAttribute("user", user);

        return "newMovie.jsp";
    }

    @PostMapping("/movies/create")
    public String createMovie(HttpSession session, Model model, @Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        if(bindingResult.hasErrors()) {
            User user = userService.findById(userId);
            model.addAttribute("user", user);
            return "newMovie.jsp";
        }

        movieService.createMovie(movie);
        return "redirect:/movies/dashboard";
    }
}
