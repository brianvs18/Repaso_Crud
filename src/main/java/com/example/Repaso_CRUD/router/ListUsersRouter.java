package com.example.Repaso_CRUD.router;

import com.example.Repaso_CRUD.dto.UserDocumentDTO;
import com.example.Repaso_CRUD.usecase.user.ListUsersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ListUsersRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllUsers(ListUsersUseCase listUsersUseCase) {
        return route(
                GET("/users").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(listUsersUseCase.findAllUsers(), UserDocumentDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findUserById(ListUsersUseCase listUsersUseCase){
        return route(
                GET("/users/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(listUsersUseCase.findUserById(request.pathVariable("id")), UserDocumentDTO.class)
        );
    }
}
