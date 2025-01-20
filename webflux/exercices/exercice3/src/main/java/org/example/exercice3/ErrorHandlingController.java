package org.example.exercice3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ErrorHandlingController {
    @GetMapping("/error-resume")
    public Flux<String> getErrorResume() {
        Flux<String> flux = Flux.just("A", "B", "C")
                .map(value -> {
                    if (value.equals("C"))
                        throw new RuntimeException("Error");
                    return value;
                })
                .onErrorResume(e -> Flux.just("Default1", "Default2"));
        flux.subscribe(System.out::println, e -> System.err.println("Error " + e));
        return flux;
    }

    @GetMapping("/error-continue")
    public Flux<Integer> getErrorContinue() {
        Flux<Integer> flux = Flux.range(1, 5)
                .map(number -> {
                    if (number == 2)
                        throw new RuntimeException("Error");
                    return number;
                })
                .onErrorContinue((e, n) -> {
                    System.err.println("Error at " + n + " -> " + e.getMessage());
                });
        flux.subscribe(System.out::println);
        return flux;
    }
}
