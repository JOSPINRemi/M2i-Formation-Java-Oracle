package org.example.exercice8.service;

import org.example.exercice8.entity.Order;
import org.example.exercice8.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> getAll() {
        return orderRepository.findAll();
    }

    public Mono<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    public Mono<Order> create(Order order) {
        return orderRepository.save(order);
    }

    public Mono<Order> update(Long id, Order order) {
        return orderRepository.findById(id)
                .flatMap(existingOrder -> {
                    existingOrder.setCustomerName(order.getCustomerName());
                    existingOrder.setTotalAmount(order.getTotalAmount());
                    existingOrder.setStatus(order.getStatus());
                    existingOrder.setCreatedAt(order.getCreatedAt());
                    return orderRepository.save(existingOrder);
                });
    }

    public Mono<Void> delete(Long id) {
        return orderRepository.deleteById(id);
    }

    public Flux<Order> getByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public Flux<Order> getAllPaged(int page, int size) {
        return Flux.empty();
        //TODO : Créer la méthode
    }
}
