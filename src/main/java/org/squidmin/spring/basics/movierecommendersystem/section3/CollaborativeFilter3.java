package org.squidmin.spring.basics.movierecommendersystem.section3;

public class CollaborativeFilter3 implements Filter {

    public String[] getRecommendations(String movie) {
        // Logic of collaborative filter.
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }

}
