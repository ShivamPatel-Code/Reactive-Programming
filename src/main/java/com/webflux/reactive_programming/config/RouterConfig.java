package com.webflux.reactive_programming.config;

import com.webflux.reactive_programming.handler.EmployeeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> employeeRoutes(EmployeeHandler handler){
        return route(GET("/employees"), handler::getAllEmployee)
                .andRoute(GET("/employee/{id}"), handler::getEmployeeById)
                .andRoute(POST("/employees"), handler::createEmployee);
    }
}
