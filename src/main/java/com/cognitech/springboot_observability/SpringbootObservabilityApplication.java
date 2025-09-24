package com.cognitech.springboot_observability;

import com.cognitech.springboot_observability.posts.JsonPlaceHolderService;
import com.cognitech.springboot_observability.posts.Post;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
//@EnableWebSecurity
public class SpringbootObservabilityApplication
{
    Logger logger = LoggerFactory.getLogger(SpringbootObservabilityApplication.class);

    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootObservabilityApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(JsonPlaceHolderService jsonPlaceHolderService, ObservationRegistry observationRegistry)
//    {
//        return args -> Observation.createNotStarted("posts.load.all.posts", observationRegistry) // custom metric name
//                .lowCardinalityKeyValue("author", "Amit Sule")    // tags for both metric and span
//                .highCardinalityKeyValue("userId", "1234")        // tags for span
//                .contextualName("posts.load-all-posts")
//                .observe(() -> {
//                    List<Post> posts = jsonPlaceHolderService.findAll();
//                    logger.info("Found posts: {}", posts.size());
//                });
//    }

    //----------------------------------------------------------------------------------------------------------
    @Bean
    @Observed(name = "posts.obs.load.all.posts", contextualName = "posts-obs-load-all-posts",
            lowCardinalityKeyValues = {"author", "Amit Sule"})
    CommandLineRunner commandLineRunner(JsonPlaceHolderService jsonPlaceHolderService)
    {
        return args -> {
            List<Post> posts = jsonPlaceHolderService.findAll();
            logger.info("Found Obs posts: {}", posts.size());
        };
    }
}
