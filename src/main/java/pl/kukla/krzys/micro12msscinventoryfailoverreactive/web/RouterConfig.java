package pl.kukla.krzys.micro12msscinventoryfailoverreactive.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import pl.kukla.krzys.micro12msscinventoryfailoverreactive.web.InventoryHandler;

/**
 * @author Krzysztof Kukla
 */
@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction inventoryRoute(InventoryHandler inventoryHandler) {
        //for InventoryHandler.listInventory will handle 'GET("/inventory-failover")' request
        return RouterFunctions.route(RequestPredicates.GET("/inventory-failover")
            .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), inventoryHandler::listInventory);
    }

}
