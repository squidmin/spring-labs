package org.squidmin.spring.basics.movierecommendersystem.section4;

import javax.annotation.PreDestroy;

public class TerminateBean4 {

    @PreDestroy
    public void onDestroy() throws Exception {
        System.out.println("Spring Container is destroyed!");
    }

}