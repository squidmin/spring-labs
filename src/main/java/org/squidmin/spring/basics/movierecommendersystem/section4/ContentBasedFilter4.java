package org.squidmin.spring.basics.movierecommendersystem.section4;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class ContentBasedFilter4 implements Filter {

    // getRecommendations takes a movie as input and returns a list of similar movies.
    public String[] getRecommendations(String movie) {

        // Implement logic of content based filter.

        // Return movie recommendations.
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }

}
