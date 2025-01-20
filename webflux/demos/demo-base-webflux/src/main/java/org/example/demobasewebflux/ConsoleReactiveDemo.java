package org.example.demobasewebflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ConsoleReactiveDemo {
    public static void main(String[] args) {
//        Simple Mono
        Mono<String > mono = Mono.just("Hello World");
        mono.subscribe(System.out::println);

//        Flux Simple
        Flux<Integer> flux = Flux.just(1, 2, 3);
        flux.subscribe(System.out::println);

//        Opération sur Flux
        Flux<Integer> flux2 = Flux.range(1, 10)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10);
        flux2.subscribe(System.out::println);

//        Erreur avec onErrorResume
        Flux<String> errorFlux = Flux.just("A", "B", "C")
                .map(value -> {
                    if ("B".equals(value))
                        throw new RuntimeException("Erreur simulée !!");
                    return value;
                })
                .onErrorResume(e -> Flux.just("Default 1", "Default 2"));
        errorFlux.subscribe(System.out::println, error -> System.err.println("Erreur recup : " + error));

//        onErrorContinue
        Flux<Integer> errorFlux2 = Flux.range(1, 5)
                .map(n -> {
                    if (n == 3)
                        throw new RuntimeException("Erreur simulée pour " + n);
                    return n;
                })
                .onErrorContinue((e, value) -> {
                    System.err.println("Erreur avec : " + value + " -> " + e.getMessage());
                });
        errorFlux2.subscribe(System.out::println);
    }
}
