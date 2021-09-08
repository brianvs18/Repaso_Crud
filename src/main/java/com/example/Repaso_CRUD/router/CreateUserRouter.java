package com.example.Repaso_CRUD.router;

import com.example.Repaso_CRUD.collections.UserDocument;
import com.example.Repaso_CRUD.dto.MoviesDocumentDTO;
import com.example.Repaso_CRUD.dto.UserDocumentDTO;
import com.example.Repaso_CRUD.usecase.movies.CreateMovieUseCase;
import com.example.Repaso_CRUD.usecase.user.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateUserRouter {

    @Bean
    public RouterFunction<ServerResponse> createUsers(CreateUserUseCase userUseCase){
        return route(POST("/users").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDocumentDTO.class)
                        .flatMap(userDocument -> userUseCase.createUser(userDocument)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
