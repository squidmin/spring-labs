package org.squidmin.spring.basics.movierecommendersystem.section4;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class RecommenderImplementation4 {

    // Filter is a dependency of RecommenderImplementation.
    @Autowired
    private Filter filter;

    public RecommenderImplementation4(Filter filter) {
        super();
        this.filter = filter;
    }

    // Use a filter to find recommendations.
    public String[] recommendMovies(String movie) {

        // Print the name of interface implementation being used.
        System.out.println("\nName of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations("Finding Dory");

        return results;
    }

}
