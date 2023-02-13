package org.squidmin.spring.basics.movierecommendersystem.section1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {
        // Create an instance of the RecommenderImplementation class.
        RecommenderImplementation recommender = new RecommenderImplementation();

        // Call the recommendMovies() method to get recommendations.
        String[] result = recommender.recommendMovies("Finding Dory");

        // Display the results.
        System.out.println(Arrays.toString(result));
    }

}
