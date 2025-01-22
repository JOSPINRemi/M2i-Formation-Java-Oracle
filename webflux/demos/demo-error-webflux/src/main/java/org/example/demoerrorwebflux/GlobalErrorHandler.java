package org.example.demoerrorwebflux;

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class GlobalErrorHandler implements ErrorWebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpRequest request = exchange.getRequest();

        System.err.println("Erreur interceptée : " + ex.getMessage() + " pour la requete " + request.getPath());

        exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);

        String errorMessage = String.format("{\"error\": \"%s\", \"path\": \"%s\"}",
                ex. getMessage (),
                request.getPath());

        return null;
    }
}
