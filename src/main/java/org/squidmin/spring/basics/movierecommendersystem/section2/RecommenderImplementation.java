package org.squidmin.spring.basics.movierecommendersystem.section2;

public class RecommenderImplementation {

    // Use the Filter interface to select filter.
    private Filter filter;

    public RecommenderImplementation(Filter filter) {
        super();
        this.filter = filter;
    }

    // Use a filter to find recommendations.
    public String[] recommendMovies(String movie) {
        // Print the name of the interface implementation being used.
        System.out.println("Name of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations("Finding Dory");

        return results;
    }

}