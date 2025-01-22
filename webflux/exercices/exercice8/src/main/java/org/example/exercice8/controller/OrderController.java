package org.example.exercice8.controller;

import org.example.exercice8.entity.Order;
import org.example.exercice8.service.OrderService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public Flux<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Order> getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @PostMapping("")
    public Mono<Order> create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @PutMapping("/{id}")
    public Mono<Order> update(@PathVariable Long id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return orderService.delete(id);
    }

    @GetMapping("/search")
    public Flux<Order> getByStatus(@RequestParam String status) {
        return orderService.getByStatus(status);
    }

    @GetMapping("/paged")
    public Flux<Order> getAllPaged(@RequestParam int page, @RequestParam int size) {
        return orderService.getAllPaged(page, size);
    }
}
