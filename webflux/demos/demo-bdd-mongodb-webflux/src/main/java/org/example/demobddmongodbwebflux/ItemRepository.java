package org.example.demobddmongodbwebflux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ItemRepository extends ReactiveMongoRepository<Item, String> {
//    Trouver par nom
    Flux<Item> findByName(String name);
}
