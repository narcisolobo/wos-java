package com.nlobo.beltexam.services;

import com.nlobo.beltexam.models.Movie;
import com.nlobo.beltexam.models.User;
import com.nlobo.beltexam.repositories.MovieRepository;
import com.nlobo.beltexam.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public MovieService(MovieRepository movieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getMovies() {
        return (List<Movie>) movieRepository.findAllByOrderByReleaseDate();
    }

    public List<Movie> getCreatedMovies(User creator) {
        return (List<Movie>) movieRepository.findByCreatorOrderByReleaseDate(creator);
    }

    public Movie getMovie(long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElse(null);
    }

    public Movie updateMovie(long id, Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()) {
            return null;
        }

        Movie movieToUpdate = movieOptional.get();
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setReleaseDate(movie.getReleaseDate());
        movieToUpdate.setDescription(movie.getDescription());
        return movieRepository.save(movieToUpdate);
    }

    public void deleteMovie(long id) {
        movieRepository.deleteById(id);
    }

    // user clicks seen button
    public void watchMovie(long userId, long movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && movie != null) {
            movie.getWatchers().add(user);
            movieRepository.save(movie);
        }
//        public Result uploadToImageKit(File imageFile) throws IOException {
//            if (imageFile == null || !imageFile.exists()) {
//                throw new IllegalArgumentException("Invalid image file");
//            }
//
//            String base64Image = Utils.fileToBase64(imageFile);
//            String filename = imageFile.getName();
//            return null;
//        }
    }

    // user clicks undo button
    public void unwatchMovie(long userId, long movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && movie != null) {
            movie.getWatchers().remove(user);
            movieRepository.save(movie);
        }
    }
}
