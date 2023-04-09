package org.squidmin.spring.basics.movierecommendersystem.section4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShutdownConfig4 {

    @Bean
    public TerminateBean4 getTerminateBean() {
        return new TerminateBean4();
    }

}
