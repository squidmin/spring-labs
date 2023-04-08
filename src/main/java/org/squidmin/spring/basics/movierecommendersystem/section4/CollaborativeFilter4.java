package org.squidmin.spring.basics.movierecommendersystem.section4;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CollaborativeFilter4 implements Filter {

    public String[] getRecommendations(String movie) {
        // Logic of collaborative filter.
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }

}
