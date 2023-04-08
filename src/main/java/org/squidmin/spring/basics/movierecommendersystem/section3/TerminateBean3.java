package org.squidmin.spring.basics.movierecommendersystem.section3;

import javax.annotation.PreDestroy;

public class TerminateBean3 {

    @PreDestroy
    public void onDestroy() throws Exception {
        System.out.println("Spring Container is destroyed!");
    }

}