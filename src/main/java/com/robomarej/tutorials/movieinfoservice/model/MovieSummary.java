package com.robomarej.tutorials.movieinfoservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieSummary {

    private String id;
    private String title;
    private String overview;
}
