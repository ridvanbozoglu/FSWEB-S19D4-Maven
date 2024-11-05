package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
         Movie movie = movieRepository
                 .findById(id)
                 .orElseThrow(() -> new ApiException("Movie is not found with id: " + id,HttpStatus.NOT_FOUND));
         return movie;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Long id, Movie movie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()){
            Movie existingMovie = optionalMovie.get();
            existingMovie.setName(movie.getName());
            existingMovie.setRating(movie.getRating());
            existingMovie.setReleaseDate(movie.getReleaseDate());
            existingMovie.setDirectorName(movie.getDirectorName());
            existingMovie.setActors(movie.getActors());
            return movieRepository.save(existingMovie);
        }else throw new RuntimeException("id ile film bulunamadı!");
    }

    @Override
    public Movie delete(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()){
            movieRepository.delete(optionalMovie.get());
            return optionalMovie.get();
        }else throw new RuntimeException("id ile film bulunamadı!");
    }

    @Override
    public Movie delete(Movie movie) {
        movieRepository.delete(movie);
        return movie;
    }


}
