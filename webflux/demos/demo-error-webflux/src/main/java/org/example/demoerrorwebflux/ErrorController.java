package org.example.demoerrorwebflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/errors")
public class ErrorController {
    @GetMapping("/{id}")
    public Mono<String> getError(@PathVariable("id") String id) {
        return Mono.just(id)
                .map(value -> {
                    if ("error".equalsIgnoreCase(value)) {
                        throw new IllegalArgumentException("ID non valide");
                    }
                    return "ID valide : " + value;
                })
                .onErrorResume(ex -> Mono.just("Erreur gérée localement " + ex.getMessage()));
    }

    @GetMapping("/global")
    public Mono<String> getGlobalError() {
        return Mono.error(new RuntimeException("Global error lancée"));
    }
}
