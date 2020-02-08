package com.robomarej.tutorials.movieinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {

    private String movieId;
    private String name;
    private String description;
}
