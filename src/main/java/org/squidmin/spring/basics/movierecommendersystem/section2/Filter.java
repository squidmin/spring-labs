package org.squidmin.spring.basics.movierecommendersystem.section2;

public interface Filter {
    public String[] getRecommendations(String movie);
}