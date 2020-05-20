package pl.kukla.krzys.micro12msscinventoryfailoverreactive.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.kukla.krzys.micro12msscinventoryfailoverreactive.model.BeerInventoryDto;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
@Component
public class InventoryHandler {

    public Mono<ServerResponse> listInventory(ServerRequest serverRequest){
        BeerInventoryDto beerInventoryDto = BeerInventoryDto.builder()
            .id(UUID.randomUUID())
            .beerId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
            .quantityOnHand(999)
            .createdDate(OffsetDateTime.now())
            .lastModifiedDate(OffsetDateTime.now())
            .build();
        List<BeerInventoryDto> beerInventoryDtoList = Collections.singletonList(beerInventoryDto);

        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_STREAM_JSON)
            .body(Mono.just(beerInventoryDtoList), List.class);
    }
}
