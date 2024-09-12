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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/movies/{movieId}")
    public String showMovie(HttpSession session, @PathVariable Long movieId, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findById(userId);
        model.addAttribute("user", user);

        Movie movie = movieService.getMovie(movieId);
        model.addAttribute("movie", movie);

        return "showMovie.jsp";
    }

    @GetMapping("/movies/{movieId}/edit")
    public String editMovie(HttpSession session, @PathVariable Long movieId, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findById(userId);
        model.addAttribute("user", user);

        Movie movie = movieService.getMovie(movieId);
        model.addAttribute("movie", movie);

        // check if logged-in user is movie creator
        if (!user.getId().equals(movie.getCreator().getId())) {
            return "redirect:/movies/dashboard";
        }
        return "editMovie.jsp";
    }

    @PostMapping("/movies/{movieId}/update")
    public String updateMovie(
            @PathVariable Long movieId,
            HttpSession session,
            Model model,
            @RequestParam("id") long id,
            @Valid @ModelAttribute("movie") Movie movie,
            BindingResult bindingResult) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        // check if logged-in user is movie creator
        if(userId != id) {
            return "redirect:/movies/dashboard";
        }

        if (bindingResult.hasErrors()) {
            User user = userService.findById(userId);
            model.addAttribute("user", user);
            return "editMovie.jsp";
        }

        movieService.updateMovie(movieId, movie);
        return "redirect:/movies/" + movieId;
    }

    @PostMapping("/movies/{movieId}/delete")
    public String deleteMovie(@PathVariable Long movieId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        Movie movie = movieService.getMovie(movieId);

        // check if logged-in user is movie creator
        if (!userId.equals(movie.getCreator().getId())) {
            return "redirect:/movies/dashboard";
        }

        movieService.deleteMovie(movieId);
        return "redirect:/movies/dashboard";
    }

    @PostMapping("/movies/watch")
    public String watchMovie(HttpSession session, @RequestParam("watcherId") Long watcherId, @RequestParam("movieId") Long movieId) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        movieService.watchMovie(watcherId, movieId);
        return "redirect:/movies/dashboard";
    }

    @PostMapping("/movies/unwatch")
    public String unwatchMovie(HttpSession session, @RequestParam("watcherId") Long watcherId, @RequestParam("movieId") Long movieId) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        movieService.unwatchMovie(watcherId, movieId);
        return "redirect:/movies/dashboard";
    }
}
