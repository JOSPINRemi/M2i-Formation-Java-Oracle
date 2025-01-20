package org.example.exercice4;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleService {
    private final List<Article> articles;

    public ArticleService() {
        articles = new ArrayList<>();
        articles.add(new Article(UUID.randomUUID(), "Introduction to Spring WebFlux"));
        articles.add(new Article(UUID.randomUUID(), "Reactive Programming with Project Reactor"));
        articles.add(new Article(UUID.randomUUID(), "Building APIs with Spring Boot"));
    }

    public Flux<Article> getArticles() {
        return Flux.fromIterable(articles);
    }
}
