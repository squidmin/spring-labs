package org.squidmin.spring.basics.movierecommendersystem.section3;

public class CollaborativeFilter implements Filter {

    public String[] getRecommendations(String movie) {
        // Logic of collaborative filter.
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }

}
