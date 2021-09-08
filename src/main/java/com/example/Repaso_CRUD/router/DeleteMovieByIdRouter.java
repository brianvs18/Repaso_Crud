package com.example.Repaso_CRUD.router;

import com.example.Repaso_CRUD.dto.MoviesDocumentDTO;
import com.example.Repaso_CRUD.usecase.movies.DeleteMovieUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteMovieByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteMovieById(DeleteMovieUseCase deleteMovieUseCase) {
        return route(
                DELETE("/movies/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(deleteMovieUseCase.deleteMovieById(request.pathVariable("id")), MoviesDocumentDTO.class)
        );
    }
}
