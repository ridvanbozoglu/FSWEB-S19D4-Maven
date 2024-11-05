package com.workintech.s19d1.dto;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActorRequest {
    private Actor actor;
    private List<Movie> movies = new ArrayList<>();
}
