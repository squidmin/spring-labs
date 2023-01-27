package org.squidmin.basics.movierecommendersystem.section2;

public class CollaborativeFilter implements Filter {

    public String[] getRecommendations(String movie) {
        // TODO: Logic of collaborative filter
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }

}
