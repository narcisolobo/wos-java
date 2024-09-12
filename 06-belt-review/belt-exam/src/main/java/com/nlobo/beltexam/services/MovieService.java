package com.nlobo.beltexam.services;

import com.nlobo.beltexam.models.Movie;
import com.nlobo.beltexam.models.User;
import com.nlobo.beltexam.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    public List<Movie> getCreatedMovies(User creator) {
        return (List<Movie>) movieRepository.findByCreator(creator);
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
}
