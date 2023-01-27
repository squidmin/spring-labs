package org.squidmin.basics.movierecommendersystem.section2;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {

        // Passing the name of the filter as a constructor argument.
        RecommenderImplementation recommender = new RecommenderImplementation(new CollaborativeFilter());

        // Call recommendMovies() method to get recommendations.
        String[] result = recommender.recommendMovies("Finding Dory");

        // Display results.
        System.out.println(Arrays.toString(result));

    }

}
