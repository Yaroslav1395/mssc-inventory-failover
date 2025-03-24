package sakhno.springframework.msscinventoryfailover.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import sakhno.springframework.msscinventoryfailover.model.BeerInventoryDto;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.UUID;

@Component
public class InventoryHandler {
    public Mono<ServerResponse> listInventory(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(Collections.singletonList(BeerInventoryDto.builder()
                        .id(UUID.randomUUID())
                        .beerId(UUID.randomUUID())
                        .quantityOnHand(999)
                        .createdDate(OffsetDateTime.now())
                        .lastModifiedDate(OffsetDateTime.now())
                        .build())), BeerInventoryDto.class);
    }
}
