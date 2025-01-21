package org.example.exercice5.service;

import org.example.exercice5.model.Task;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TaskService {
    private final Map<UUID, Task> tasks;

    public TaskService() {
        this.tasks = new ConcurrentHashMap<>();
    }

    public Mono<Task> create(Task task) {
        UUID id = UUID.randomUUID();
        task.setId(id);
        tasks.put(id, task);
        return Mono.just(task);
    }

    public Flux<Task> getAll() {
        return Flux.fromIterable(tasks.values());
    }

    public Mono<Task> getById(UUID id) {
        return Mono.just(tasks.get(id));
    }

    public Mono<Task> update(UUID id, Task task) {
        task.setId(id);
        tasks.put(id, task);
        return Mono.just(task);
    }

    public Mono<Task> delete(UUID id) {
        return Mono.just(tasks.remove(id));
    }
}
