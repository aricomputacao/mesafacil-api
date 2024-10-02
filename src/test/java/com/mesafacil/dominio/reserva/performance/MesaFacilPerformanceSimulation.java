package com.mesafacil.dominio.reserva.performance;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;


public class MesaFacilPerformanceSimulation extends Simulation{
    private final HttpProtocolBuilder httpProtocol =
            http.baseUrl("http://localhost:8080")
                    .header("content-type", "application/json");



    ActionBuilder buscaRestaurantesRequest = http("Buscar restaurantes")
            .get("/api/v1/reserva/restaurante")
            .check(status().is(200));

    ScenarioBuilder cenarioBuscaRestaurante = scenario("Busca Restaurantes")
            .exec(buscaRestaurantesRequest);

    {
       setUp(
               cenarioBuscaRestaurante.injectOpen(
                       rampUsersPerSec(1)
                               .to(50)
                               .during(Duration.ofSeconds(10)),
                       constantUsersPerSec(50)
                               .during(Duration.ofSeconds(20)),
                       rampUsersPerSec(50)
                               .to(1)
                               .during(Duration.ofSeconds(10))
               )
       )
               .protocols(httpProtocol)
               .assertions(
                       global().responseTime().max().lt(50)
               );
    }

}
