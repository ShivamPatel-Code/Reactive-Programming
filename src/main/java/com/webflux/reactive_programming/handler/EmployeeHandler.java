package com.webflux.reactive_programming.handler;

import com.webflux.reactive_programming.model.Employee;
import com.webflux.reactive_programming.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeHandler {

    private final EmployeeService employeeService;

    public EmployeeHandler(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public Mono<ServerResponse> getAllEmployee(ServerRequest request){
        Flux<Employee> employeeFlux = Flux.fromIterable(employeeService.getAllEmployees());
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employeeFlux, Employee.class);
    }

    public Mono<ServerResponse> getEmployeeById(ServerRequest request){
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<Employee> employeeMono = Mono.justOrEmpty(employeeService.getEmployeeById(id));
        return employeeMono.flatMap(employee ->
                ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(employee)
                )
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createEmployee(ServerRequest request){
        Mono<Employee> employeeMono = request.bodyToMono(Employee.class);
        return employeeMono.flatMap(employee ->
                    ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(employeeService.createEmployee(employee))
                );
    }

}
