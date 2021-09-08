package com.example.Repaso_CRUD.router;

import com.example.Repaso_CRUD.dto.MoviesDocumentDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.example.Repaso_CRUD.usecase.movies.ListMoviesUseCase;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ListMoviesRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllMovies(ListMoviesUseCase listMoviesUseCase) {
        return route(
                GET("/movies").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(listMoviesUseCase.findAllMovies(), MoviesDocumentDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findMovieById(ListMoviesUseCase listMoviesUseCase){
        return route(
                GET("/movies/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(listMoviesUseCase.findMovieById(request.pathVariable("id")), MoviesDocumentDTO.class)
        );
    }
}
