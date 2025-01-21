package org.example.exercice5.router;

import org.example.exercice5.handler.TaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TaskRouter {
    @Bean
    public RouterFunction<ServerResponse> taskRoutes(TaskHandler taskHandler) {
        return route(GET("/api/tasks"), taskHandler::getAll)
                .andRoute(GET("/api/tasks/{id}"), taskHandler::getById)
                .andRoute(POST("/api/tasks"), taskHandler::create)
                .andRoute(PUT("/api/tasks/{id}"), taskHandler::update)
                .andRoute(DELETE("/api/tasks/{id}"), taskHandler::delete);
    }
}
