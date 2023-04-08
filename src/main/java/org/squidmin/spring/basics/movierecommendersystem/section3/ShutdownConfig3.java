package org.squidmin.spring.basics.movierecommendersystem.section3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.squidmin.spring.basics.movierecommendersystem.section3")
public class ShutdownConfig3 {

    @Bean
    public TerminateBean3 getTerminateBean() {
        return new TerminateBean3();
    }

}
