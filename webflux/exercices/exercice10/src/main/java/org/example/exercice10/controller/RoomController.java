package org.example.exercice10.controller;

import org.example.exercice10.entity.Room;
import org.example.exercice10.service.RoomService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("")
    public Flux<Room> getAll() {
        return roomService.getAll();
    }

    @PostMapping("")
    public Mono<Room> create(@RequestBody Room room) {
        return roomService.create(room);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return roomService.deleteById(id);
    }
}
