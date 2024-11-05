package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable Long id){
        return movieService.findById(id);
    }

    @PostMapping("/")
    public Movie save(@RequestBody Movie movie){
        return movieService.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie movie){
        return movieService.update(id,movie);
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable Long id){
        return movieService.delete(id);
    }
}
