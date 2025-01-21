package org.example.exercice7.controller;

import org.example.exercice7.entity.User;
import org.example.exercice7.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public Flux<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> getById(@PathVariable String id) {
        return userService.getById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public Mono<ResponseEntity<User>> create(@RequestBody User user) {
        return userService.create(user)
                .map(body -> new ResponseEntity<>(body, HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> update(@PathVariable String id, @RequestBody User user) {
        return userService.update(id, user)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return userService.delete(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}
