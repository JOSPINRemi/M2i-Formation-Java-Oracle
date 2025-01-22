package org.example.exercice10.service;

import org.example.exercice10.entity.Room;
import org.example.exercice10.repository.RoomRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Flux<Room> getAll() {
        return roomRepository.findAll();
    }

    public Mono<Room> create(Room room) {
        return roomRepository.save(room);
    }

    public Mono<Void> deleteById(Long id) {
        return roomRepository.deleteById(id);
    }
}
