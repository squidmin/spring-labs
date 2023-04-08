package org.squidmin.spring.basics.movierecommendersystem.section3;

import org.springframework.stereotype.Component;

@Component
public class ContentBasedFilter3 implements Filter {

    // getRecommendations takes a movie as input and returns a list of similar movies.
    public String[] getRecommendations(String movie) {

        // Implement logic of content based filter.

        // Return movie recommendations.
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }

}
