package org.example.exercice7.service;

import org.example.exercice7.entity.User;
import org.example.exercice7.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    public Mono<User> getById(String id) {
        return userRepository.findById(id);
    }

    public Mono<User> create(User user) {
        return userRepository.save(user);
    }

    public Mono<User> update(String id, User user) {
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setActive(user.isActive());
                    return userRepository.save(existingUser);
                });
    }

    public Mono<Void> delete(String id) {
        return userRepository.deleteById(id);
    }
}
