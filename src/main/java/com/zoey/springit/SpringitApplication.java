package com.zoey.springit;

import com.zoey.springit.domain.Comment;
import com.zoey.springit.domain.Link;
import com.zoey.springit.repository.CommentRepository;
import com.zoey.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    //@Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("Getting Started with Spring Boot 2", "https://spring.io/projects/spring-boot");
            linkRepository.save(link);

            Comment comment = new Comment("This Spring Boot 2 link is awesome!", link);
            commentRepository.save(comment);
            link.addComment(comment);
        };
    }
}
