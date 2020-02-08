package com.robomarej.tutorials.movieinfoservice.controller;

import com.robomarej.tutorials.movieinfoservice.model.Movie;
import com.robomarej.tutorials.movieinfoservice.model.MovieSummary;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    @Value("${the-movie-db.api.key}")
    private String movieDbApiKey;

    @Value("${the-movie-db.url}")
    private String movieDbUrl;

    @Value("${the-movie-db.endpoint.movie}")
    private String movieDbEndpointMovie;

    private final RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId){
        String movieDbRestUrl = movieDbUrl + movieDbEndpointMovie + "/" + movieId + "?api_key=" + movieDbApiKey;
        MovieSummary movieDbResponse = restTemplate.getForObject(movieDbRestUrl, MovieSummary.class);
        return new Movie(movieId, movieDbResponse.getTitle(), movieDbResponse.getOverview());
    }
}
