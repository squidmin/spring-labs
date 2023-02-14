package org.squidmin.spring.basics.movierecommendersystem.section3;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {
//        run(args);
//        exitApplication();
        writePID();
    }

    private static void run(String[] args) {
        // ApplicationContext manages the beans and dependencies.
        ApplicationContext ctx = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

        // Use ApplicationContext to find which filter is being used.
        RecommenderImplementation recommender = ctx.getBean(RecommenderImplementation.class);

        // Call method to get recommendations.
        String[] result = recommender.recommendMovies("Finding Dory");

        // Display results.
        System.out.println(Arrays.toString(result));

        System.exit(0);
    }

    private static void exitApplication() {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MovieRecommenderSystemApplication.class)
            .web(WebApplicationType.SERVLET).run();

        int exitCode = SpringApplication.exit(ctx, () -> {
            // Return the error code.
            return 0;
        });

        System.out.println("Exit Spring Boot");

        System.exit(exitCode);
    }

    private static void writePID() {
        /*
         * 1. Send a POST request to the `shutdown` actuator endpoint: curl -X POST localhost:8080/actuator/shutdown
         * 2. A PID file is written to the path: "./bin/shutdown.pid"
         * 3. Use: kill $(cat ./bin/shutdown.pid) to shut down the application from a terminal
         */
        SpringApplicationBuilder app = new SpringApplicationBuilder(MovieRecommenderSystemApplication.class)
            .web(WebApplicationType.SERVLET);
        app.build().addListeners(new ApplicationPidFileWriter("./bin/shutdown.pid"));
        app.run();
    }

}
