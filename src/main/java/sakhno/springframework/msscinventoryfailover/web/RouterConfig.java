package sakhno.springframework.msscinventoryfailover.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {
    /**
     * Метод определяет Маршрут (Router) для обработки HTTP-запросов в Spring WebFlux.
     * Он регистрирует обработку GET-запроса по пути "/inventory-failover" с ожиданием ответа в формате JSON.
     * @param inventoryHandler - объект
     * @return - маршрут
     */
    @Bean
    public RouterFunction inventoryRoute(InventoryHandler inventoryHandler) {
        return route(GET("/inventory-failover").and(accept(MediaType.APPLICATION_JSON)), inventoryHandler::listInventory);
    }
}
