package com.example.Repaso_CRUD.router;

import com.example.Repaso_CRUD.dto.UserDocumentDTO;
import com.example.Repaso_CRUD.usecase.user.DeleteUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteUserByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteUserById(DeleteUserUseCase deleteUserUseCase) {
        return route(
                DELETE("/users/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(deleteUserUseCase.deleteUserById(request.pathVariable("id")), UserDocumentDTO.class)
        );
    }
}
