package org.example.exercice4;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    private final List<String> articles;

    public ArticleService() {
        articles = new ArrayList<>();
        articles.add("Introduction to Spring WebFlux");
        articles.add("Reactive Programming with Project Reactor");
        articles.add("Building APIs with Spring Boot");
    }

    public Flux<String> getArticles() {
        return Flux.fromIterable(articles);
    }
}
