package org.example.exercice8.repository;

import org.example.exercice8.entity.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
    Flux<Order> findByStatus(String status);
}
