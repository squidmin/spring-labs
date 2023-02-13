package org.squidmin.spring.basics.movierecommendersystem.section2;

public class ContentBasedFilter implements Filter {

    public String[] getRecommendations(String movie) {
        // TODO: Logic of content based filter

        // Return movie recommendations.
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }

}
