package org.example.exercice5.handler;

import org.example.exercice5.model.Task;
import org.example.exercice5.service.TaskService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class TaskHandler {
    private final TaskService taskService;

    public TaskHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Task.class)
                .flatMap(taskService::create)
                .flatMap(task -> created(serverRequest.uri()).bodyValue(task));
    }

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ok().body(taskService.getAll(), Task.class);
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        UUID id = UUID.fromString(serverRequest.pathVariable("id"));
        return taskService.getById(id)
                .flatMap(task -> ok().bodyValue(task))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        UUID id = UUID.fromString(serverRequest.pathVariable("id"));
        /*Task task = serverRequest.bodyToMono(Task.class);
        return taskService.update(id, )*/
        return serverRequest.bodyToMono(Task.class)
                .flatMap(task -> taskService.update(id, task))
                .flatMap(task -> ok().bodyValue(task));
    }

    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        UUID id = UUID.fromString(serverRequest.pathVariable("id"));
        taskService.delete(id);
        return noContent().build();
    }
}
