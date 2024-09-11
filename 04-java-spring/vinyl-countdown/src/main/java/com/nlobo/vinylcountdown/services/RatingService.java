package com.nlobo.vinylcountdown.services;

import com.nlobo.vinylcountdown.models.Album;
import com.nlobo.vinylcountdown.models.Rating;
import com.nlobo.vinylcountdown.models.User;
import com.nlobo.vinylcountdown.repositories.AlbumRepository;
import com.nlobo.vinylcountdown.repositories.RatingRepository;
import com.nlobo.vinylcountdown.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;

    public RatingService(RatingRepository ratingRepository, AlbumRepository albumRepository, UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
    }

    public void createRating(long raterId, long albumId, int score) {
        Album album = albumRepository.findById(albumId).orElse(null);
        User rater = userRepository.findById(raterId).orElse(null);

        if (album != null || rater != null) {
            Rating rating = new Rating();
            rating.setAlbum(album);
            rating.setRater(rater);
            rating.setScore(score);
            ratingRepository.save(rating);
        }
    }
}
